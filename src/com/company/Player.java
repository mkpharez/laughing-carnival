package com.company;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject{

    Random r = new Random();

    public Player(int x, int y, IDs id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        if(id == IDs.Player) g.setColor(Color.white);
        else if(id == IDs.Player3) g.setColor(Color.black);
        g.fillRect(x,y,32,32);
    }
}
