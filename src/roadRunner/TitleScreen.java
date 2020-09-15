/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Andrey
 */
public class TitleScreen {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private GameGUI setting;
    scoreIO io = new scoreIO();

    /**
     * runs prepareGUI method
     */
    public TitleScreen() {
        prepareGUI();
    }

    public static void main(String[] args) {
        TitleScreen swingControlDemo = new TitleScreen();
        swingControlDemo.showButtonDemo();
    }

    /**
     * creates frame
     */
    private void prepareGUI() {
        mainFrame = new JFrame("Road Runner");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(10, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);

        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400); //600x400 size

    }

    /**
     * creates buttons and button actions
     */
    public void showButtonDemo() {
        headerLabel.setText("Welcome to road runner! Type in your name in the textfield and press play");

        JButton playButton = new JButton("Play");
        JButton scoresButton = new JButton("Last Score");
        JButton exitButton = new JButton("Exit");
        TextField t1 = new TextField("");

        //play button
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Play Button clicked.");
                String name = t1.getText(); //sets name to text in textfield
                mainFrame.dispose(); //closes titlescreen
                GameGUI setting = new GameGUI(name); //opens main game window
 
            }
        });

        //scores button
        scoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText(io.readScore()); //displays score
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //exits
            }
        });

        //add buttons and textfield
        controlPanel.add(playButton);
        controlPanel.add(scoresButton);
        controlPanel.add(exitButton);
        mainFrame.add(t1);

        mainFrame.setVisible(true);
    }
}
