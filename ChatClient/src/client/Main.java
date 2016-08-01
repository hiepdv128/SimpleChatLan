/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hellb
 */
public class Main {

    private static final String HOSTNAME = "localhost";
    private static final int HOST = 8088;

    public static void main(String[] args) throws IOException {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        Socket socketClient = null;
        String userName;
        Scanner scan = new Scanner(System.in);
        System.out.println("Tên bạn : ");
        userName = scan.nextLine();

        try {
            socketClient = new Socket(HOSTNAME, HOST);
            inputStream = new ObjectInputStream(socketClient.getInputStream());
            outputStream = new ObjectOutputStream(socketClient.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        MsgReceiver msgReceiver = new MsgReceiver(inputStream);
        MsgSender msgSender = new MsgSender(userName,outputStream);
        msgReceiver.start();
        msgSender.start();
        //TODO: handle when close connection
//        while (true) {
//            if (!msgSender.isAlive()) {
//                msgReceiver.interrupt();
//                socketClient.close();
//            }
//        }
    }
}
