package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
    private Thread thread;
    private Handler handler;
    private boolean running = false;
    private Random r;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "WAVEGame", this);
        
        r = new Random();

        for(int i = 0; i < 50; i++)
            handler.addObject(new Player(WIDTH/2-32,  HEIGHT/2-32,  IDs.Player));
            handler.addObject(new Player(WIDTH/2+64,  HEIGHT/2-32,  IDs.Player3));
    }

    public static void main(String[] args) {
        new Game();

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double  amountOfTicks = 60.0;
        double nanoSec = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime)/nanoSec;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
                frames++;
                if (System.currentTimeMillis()- timer > 1000){
                    timer += 1000;
                    //System.out.println("FPS:" + frames);
                    frames = 0;
                }
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.cyan);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        handler.tick();

    }
}
