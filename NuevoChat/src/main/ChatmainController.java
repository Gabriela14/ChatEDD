/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.bigchat.es.biglauncher.gui.ChatvistaLauncher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import server.chatServer;
import cliente.chatClient;

/**
 *
 * @author aorozco
 */
public class ChatmainController{
    
    private ChatvistaLauncher gui;
    private ActionListener actionListenerLaunchServer;
    private ActionListener actionListenerLaunchClient;

    public ChatmainController(ChatvistaLauncher gui) {
        this.gui = gui;
    }

    public void triggerBtnLaunchServer(){
        actionListenerLaunchServer = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                gui.getReferenceBtnLaunchServer().setEnabled(false);
                new chatServer().chatServerStart();
            }
        };
        gui.getReferenceBtnLaunchServer().addActionListener(actionListenerLaunchServer);
    }
    
    public void triggerBtnLaunchClient(){
        actionListenerLaunchClient = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                new chatClient().chatClientStart();
            }
        };
        gui.getReferenceBtnLaunchClient().addActionListener(actionListenerLaunchClient);
    }
    
    
}
