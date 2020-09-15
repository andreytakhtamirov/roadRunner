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
public class Coin extends Player implements Runnable {

    private GameGUI newGame;
    public int direction = 1; //facing right
    private Player player1;
    private int speed;

    /**
     * constructor
     * @param lives 
     * @param xLocation // x coordinate of the coin
     * @param yLocation //y coordinate of the coin
     * @param isAlive
     * @param newGame
     * @param player1 
     */
    public Coin(int lives, int xLocation, int yLocation, boolean isAlive, GameGUI newGame, Player player1) {
        super(lives, xLocation, yLocation, isAlive, 0, null);
        this.newGame = newGame;
        this.player1 = player1;
        speed = player1.getSpeed();
    }

    /**
     * controls movement of the coin
     */
    @Override
    public void run() {
        int coinSpeed = 4; // movement speed of the coin
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(random.nextInt(speed)); //refresh speed
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "thread interrupted");
                System.exit(1);
            }

            if (getxLocation() < new Random().nextInt(60)) { // movement bounds
                direction = 1;
            } else if (getxLocation() > new Random().nextInt(800) + 250) {
                direction = -1; //changes direction
            }

            hit();
            setxLocation(getxLocation() + coinSpeed * direction);
            newGame.repaint();
        }
    }

    /**
     * creates a rectangle for the player and coin
     * checks if coin rectangle is inside player rectangle
     */
    public void hit() {
        Rectangle playerHitBox = new Rectangle(player1.getxLocation() - 20, player1.getyLocation() - 20, 80, 80);
        Rectangle coinHitBox = new Rectangle(this.getxLocation(), this.getyLocation(), 20, 20);

        if (playerHitBox.contains(coinHitBox)) {
            player1.setxLocation(50); //move the player back
            player1.setyLocation(50);
            player1.addPoints(100); // add 100 points
            player1.setSpeed(player1.getSpeed() - 5); //sets the refresh speed smaller (faster refresh)
            speed = player1.getSpeed(); 

        }
    }

    /**
     * displays the coin on the screen
     * pre: coin instantiated
     * post: draws sprite from given file and sprite length/width (20x20 square)
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon("coin.png");
        g.drawImage(image.getImage(), xLocation, yLocation, 20, 20, null);
    }
}
