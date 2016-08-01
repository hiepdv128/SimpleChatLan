/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hellb
 */
public class HandleMessage extends Thread {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ArrayList<ObjectOutputStream> listClient;

    public HandleMessage(Socket socket, ArrayList listClient) {
        this.socket = socket;
        this.listClient = listClient;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            listClient.add(outputStream);
        } catch (IOException ex) {
            Logger.getLogger(HandleMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message mess = (Message) inputStream.readObject();
                broadCast(mess);
                display(mess);
            }
        } catch (IOException | ClassNotFoundException ex) {
               Logger.getLogger(HandleMessage.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public void broadCast(Message message) {
        try {
            for (ObjectOutputStream client : listClient) {
                client.writeObject(message);
                client.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void display(Message message) {
        System.out.println(message.getUserName() + ": " + message.getContent());
    }
}
