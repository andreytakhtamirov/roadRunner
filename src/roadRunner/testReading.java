/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class testReading {

    public static void main(String[] args) {
        File stuFile = new File("scoreBoard.dat");
        FileInputStream in;
        ObjectInputStream readStu;
        ArrayList<Player> players = new ArrayList();

        try {
            in = new FileInputStream(stuFile);
            readStu = new ObjectInputStream(in);

            Object temp;

            temp = readStu.readObject();
            System.out.println(temp);
            players = (ArrayList) temp;

            readStu.close();

            in.close();
        } catch (IOException e) {
            System.out.println("Problems with I/O");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testReading.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
