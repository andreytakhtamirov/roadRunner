/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class GameGUI extends JPanel {
    
    JFrame window = new JFrame("road runner");
    Player player = new Player(4, 50, 50, true, 0, ""); //4 lives, starting point x:50, 50
    input keyEvents = new input(player, this);
    Enemy enemy1 = new Enemy(1, 300, 200, true, this, player); //starting point x:300 y:200
    Enemy enemy2 = new Enemy(1, 300, 300, true, this, player); //starting point x:300 y:300
    Enemy enemy3 = new Enemy(1, 300, 350, true, this, player); //starting point x:300 y:350
    Enemy enemy4 = new Enemy(1, 300, 400, true, this, player); //starting point x:300 y:400
    Enemy enemy5 = new Enemy(1, 300, 500, true, this, player); //starting point x:300 y:500
    Enemy enemy6 = new Enemy(1, 300, 600, true, this, player); //starting point x:300 y:600
    Coin coin = new Coin(1, 400, 650, true, this, player); //starting point x:400 y:650
    scoreIO io = new scoreIO();

    public GameGUI(String playerName) {
        window.addKeyListener(keyEvents);
        window.setFocusable(true);
        window.add(this);
        player.setName(playerName);
        Thread thread = new Thread(enemy1);
        Thread thread2 = new Thread(enemy2);
        Thread thread3 = new Thread(enemy3);
        Thread thread4 = new Thread(enemy4);
        Thread thread5 = new Thread(enemy5);
        Thread thread6 = new Thread(enemy6);

        Thread thread7 = new Thread(coin);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(440, 750);
        window.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon background = new ImageIcon("background.png");
        g.drawImage(background.getImage(), 0, 0, null);
        player.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        enemy3.draw(g);
        enemy4.draw(g);
        enemy5.draw(g);
        enemy6.draw(g);
        coin.draw(g);

        /////////////useful stuff for debugging//////////////
        //System.out.println(player); 
        //System.out.println(player.getLives() + " Lives ");
        //System.out.println(player.xLocation + " x");                 
        //System.out.println(player.yLocation + " y");
        //System.out.println("player score: " + player.getScore());
        //System.out.println("player name: " + player.getName());
        //System.out.println("speed: " + player.getSpeed());
        
        if (!player.isAlive()) {
            window.dispose();
            io.writeScore(player);
        }
    }
}
