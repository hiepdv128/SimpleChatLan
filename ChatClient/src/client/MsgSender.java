/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author hellb
 */
public class MsgSender extends Thread {
    private ObjectOutputStream outputStream;
    private String userName;
    private Scanner scanner;

    public MsgSender(String userName, ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
        this.userName = userName;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String mess;
        try {
            while (true) {
                mess = scanner.nextLine();
                outputStream.writeObject(new Message(mess, userName));
//                if (mess.equalsIgnoreCase("quit")) {
//                    outputStream.close();
//                    break;
//                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
