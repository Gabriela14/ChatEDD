/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.bigchat.es.biglauncher.gui.ChatvistaLauncher;

/**
 *
 * @author aorozco
 */
public class Chatmain implements Runnable{
    
    //member attributes implementing the MVC design pattern
    private ChatvistaLauncher view;
    private ChatmainController controller;
    
    public Chatmain(){
        view = new ChatvistaLauncher();
        controller = new ChatmainController(view);
    }
    
    @Override
    public void run(){
        view.setVisible(true);
        controller.triggerBtnLaunchServer();
        controller.triggerBtnLaunchClient();
    }
    
    public static void main(String[] args){
        new Chatmain().run();
    }
}
