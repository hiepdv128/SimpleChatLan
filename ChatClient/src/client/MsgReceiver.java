/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hellb
 */
public class MsgReceiver extends Thread {

    private ObjectInputStream inputStream;

    public MsgReceiver(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = (Message) inputStream.readObject();
                display(msg);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void display(Message msg) {
        System.out.println(msg.getUserName() + ": " + msg.getContent());
    }
}
