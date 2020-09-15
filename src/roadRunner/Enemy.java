/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrey
 */
public class Enemy extends Player implements Runnable {

    private GameGUI newGame;
    public int direction = 1; //facing right
    private Player player1;
    private int speed;

    /**
     * constructor
     * @param lives
     * @param xLocation //x coordinate
     * @param yLocation //y coordinate
     * @param isAlive
     * @param newGame
     * @param player1 
     */
    public Enemy(int lives, int xLocation, int yLocation, boolean isAlive, GameGUI newGame, Player player1) {
        super(lives, xLocation, yLocation, isAlive, 0, null);
        this.newGame = newGame;
        this.player1 = player1;
        speed = player1.getSpeed();
    }

    /**
     * controls movement of the enemy
     */
    @Override
    public void run() {
        int enemySpeed = 5; // movement speed of enemy
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(speed)); //refresh rate
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "thread interrupted");
                System.exit(1);
            }

            if (getxLocation() < new Random().nextInt(60)) { // movement bounds
                direction = 1;
            } else if (getxLocation() > new Random().nextInt(800) + 300) {
                direction = -1; //changes direction
            }
            hit();
            setxLocation(getxLocation() + enemySpeed * direction);
            newGame.repaint();
            speed = player1.getSpeed();
        }
    }

    /**
     * creates a rectangle for the player and enemy
     * checks if enemy rectangle is inside player rectangle
     */
    public void hit() {
        Rectangle playerHitBox = new Rectangle(player1.getxLocation() - 20, player1.getyLocation() - 20, 80, 80);
        Rectangle enemyHitBox = new Rectangle(this.getxLocation(), this.getyLocation(), 20, 20);

        if (playerHitBox.contains(enemyHitBox)) {
            player1.setLives(player1.getLives() - 1);
            player1.setxLocation(50); //moves player to (50, 50)
            player1.setyLocation(50);
            if (player1.getLives() == 0) {
                player1.setIsAlive(false);
                JOptionPane.showMessageDialog(null, "you died");
                TitleScreen swingControlDemo = new TitleScreen();
                swingControlDemo.showButtonDemo();
            }
        }
    }

    /**
     * displays the enemy on the screen
     * pre: enemy instantiated
     * post: draws sprite from given file and sprite length/width (40x40 square)
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon("enemy.png");
        g.drawImage(image.getImage(), xLocation, yLocation, 20, 20, null);
    }
}
