package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput( Handler handler){this.handler=handler;}

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
          GameObject objects = handler.object.get(i);
          if(objects.getId() == IDs.Player) {
              /*key events for player*/
              if (key == KeyEvent.VK_W) objects.setVelY(-5);
              if (key == KeyEvent.VK_S) objects.setVelY(5);
              if (key == KeyEvent.VK_D) objects.setVelX(5);
              if (key == KeyEvent.VK_A) objects.setVelX(-5);
          }
          if(objects.getId() == IDs.Player3) {
              /*key events for player3*/
              if (key == KeyEvent.VK_UP) objects.setVelY(-5);
              if (key == KeyEvent.VK_DOWN) objects.setVelY(5);
              if (key == KeyEvent.VK_LEFT) objects.setVelX(-5);
              if (key == KeyEvent.VK_RIGHT) objects.setVelX(5);
          }
        }
        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();

            for(int i = 0; i < handler.object.size(); i++){
                GameObject objects = handler.object.get(i);
                if(objects.getId() == IDs.Player) {
                    /*key events for player*/
                    if (key == KeyEvent.VK_W) objects.setVelY(0);
                    if (key == KeyEvent.VK_S) objects.setVelY( 0);
                    if (key == KeyEvent.VK_D) objects.setVelX(0);
                    if (key == KeyEvent.VK_A) objects.setVelX(0);
                }
                if(objects.getId() == IDs.Player3) {
                    /*key events for player3*/
                    if (key == KeyEvent.VK_UP) objects.setVelY(0);
                    if (key == KeyEvent.VK_DOWN) objects.setVelX(0);
                    if (key == KeyEvent.VK_LEFT) objects.setVelY(0);
                    if (key == KeyEvent.VK_RIGHT) objects.setVelX(0);
                }
            }
        }
}
