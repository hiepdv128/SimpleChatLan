/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author hellb
 */
public class Main {
    private static final int HOST = 8088;
    
    public static void main(String[] args) throws IOException {
        ArrayList<ObjectOutputStream> listClient = new ArrayList<>();
        ServerSocket listener = new ServerSocket(HOST);
        new HandleConnect(listClient, listener).start();
        
    }
}
