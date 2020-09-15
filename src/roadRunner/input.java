/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Andrey
 */
public class input implements KeyListener {

    private Player player;
    private GameGUI gui;
    boolean down, up, left, right;

    /**
     * constructor
     * @param player
     * @param gui 
     */
    public input(Player player, GameGUI gui) {
        this.player = player;
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * checks to see where to move the player when called by keyPressed or keyReleased methods
     */
    private void update() {
        int speed = 5; //default player movement speed

        if (down) {
            player.setyLocation(player.getyLocation() + speed);
            gui.repaint();
        }
        if (up) {
            player.setyLocation(player.getyLocation() - speed);
            gui.repaint();
        }
        if (left) {
            player.setxLocation(player.getxLocation() - speed);
            gui.repaint();
        }
        if (right) {
            player.setxLocation(player.getxLocation() + speed);
            gui.repaint();
        }
    }

    /**
     * checks what key the user is pressing, sets movement variables accordingly
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
        update();
    }

    /**
     * checks to see if keys are still pressed
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
        update();
    }
}
