/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hellb
 */
public class HandleConnect extends Thread {

    ArrayList<ObjectOutputStream> listClient = null;
    ServerSocket listener = null;

    public HandleConnect(ArrayList listClient, ServerSocket listener) {
        this.listClient = listClient;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Waiting new client....");
                Socket client = listener.accept();
                System.out.println("New connect!");
                new HandleMessage(client, listClient).start();
                sleep(5);

            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
