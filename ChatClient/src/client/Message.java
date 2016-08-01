/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.Serializable;

/**
 *
 * @author hellb
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1234567890L;
    private String content;
    private String userName; 

    public Message(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }
    
}
