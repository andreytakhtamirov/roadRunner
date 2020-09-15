/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Andrey
 */
public class Player implements Serializable {

    public int lives;
    public int xLocation;
    public int yLocation;
    public boolean isAlive;
    public int score;
    public String name;
    public int speed = 40; //starting refresh speed (lower is faster)

    /**
     * constructor
     * @param lives // lives of the player
     * @param xLocation //x coordinate of the starting location
     * @param yLocation // y coordinate of the starting location
     * @param isAlive
     * @param name
     */
    public Player(int lives, int xLocation, int yLocation, boolean isAlive, int score, String name) {
        this.lives = lives;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.isAlive = isAlive;
        this.score = score;
        this.name = name;
    }

    /**
     * sets the number of lives of the player to the given parameter
     * pre: player instantiated
     * post: changes player lives
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * sets the bounds for xLocation of the player
     * pre: player instantiated
     * post: stops the player from going off the screen (x axis limit)
     * @param xLocation 
     */
    public void setxLocation(int xLocation) {
        if (isAlive) {
            if (this.xLocation > 350) {
                this.xLocation = 350;
            } else if (this.xLocation < 20) {
                this.xLocation = 20;
            } else {
                this.xLocation = xLocation;
            }
        } else {
            this.xLocation = xLocation;
        }

    }
    /**
     * sets the bounds for yLocation of the player
     * pre: player instantiated
     * post: stops the player from going off the screen (y axis limit)
     * @param yLocation 
     */
    public void setyLocation(int yLocation) {
        if (isAlive) {
            if (this.yLocation > 650) {
                this.yLocation = 650;
            } else if (this.yLocation < 20) {
                this.yLocation = 20;
            } else {
                this.yLocation = yLocation;
            }
        } else {
            this.yLocation = yLocation;
        }
    }

    /**
     * stores boolean that says if player is alive/dead
     * pre: player instantiated
     * post: changes to a given boolean parameter
     * @param isAlive 
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    /**
     * sets the movement speed of the player to a given speed
     * pre: player instantiated
     * post: changes speed to a given int parameter
     * @param speed 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * displays the player on the screen
     * pre: player instantiated
     * post: draws sprite from given file and sprite length/width (40x40 square)
     * @param g 
     */
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon("pacman.png"); //sprite
        g.drawImage(image.getImage(), xLocation, yLocation, 40, 40, null);
    }

    /**
     * returns an int representing the lives of the player
     * @return 
     */
    public int getLives() {
        return lives;
    }

    /**
     * returns an int represeting the x coordinate of the player
     * @return 
     */
    public int getxLocation() {
        return xLocation;
    }

    /**
     * returns an int representing the y coordinate of the player
     * @return 
     */
    public int getyLocation() {
        return yLocation;
    }

    /**
     * returns an int representing the movement speed of the player
     * @return 
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * adds given points passed to the score of the player
     * @param points 
     */
    public void addPoints(int points) {
        score += points;
    }

    /**
     * returns an int representing the score of the player
     * @return 
     */
    public int getScore() {
        return score;
    }

    /**
     * returns a boolean representing the alive status of the player
     * true - alive, false - dead
     * @return 
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * sets the name of the player to a passed string parameter
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns a string representing the name of the player
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * returns a string representing the player's stats
     * @return 
     */
    @Override
    public String toString() {
        return ("Name: " + name + ", Score: " + score);
        //return ("Name " + name + ", Score: " + score + "lives" + lives + "xLocation " + xLocation + " yLocation " + yLocation + "alive? " + isAlive);
    }

}
