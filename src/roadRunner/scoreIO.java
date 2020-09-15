/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Andrey
 */
public class scoreIO {

    File stuFile = new File("scoreBoard.dat");

    /**
     * reads file and returns a string with the player object
     * @return 
     */
    public String readScore() {
        FileInputStream in;
        ObjectInputStream readStu;
        ArrayList<Player> players = new ArrayList();
        String output = "";

        try {
            in = new FileInputStream(stuFile);
            readStu = new ObjectInputStream(in);

            Object temp;

            temp = readStu.readObject();
            //System.out.println(temp);
            output += temp;
            players = (ArrayList) temp;

            readStu.close();

            in.close();
        } catch (IOException e) {
            System.out.println("Problems with I/O");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found.");
        }
        return output;
    }

    /**
     * writes player object to file
     * @param player 
     */
    public void writeScore(Player player) {
        FileOutputStream out;
        ObjectOutputStream writeStu;
        ArrayList students = new ArrayList();

        students.add(player);

        try {
            out = new FileOutputStream(stuFile);
            writeStu = new ObjectOutputStream(out);

            writeStu.writeObject(students);

            writeStu.close();
            out.close();

        } catch (IOException e) {
            System.out.println("Problem with I/O");
        }
    }
}
