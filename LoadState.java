package com.crobin.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.crobin.game.main.Resources;

public class LoadState extends State {

    @Override
    public void init() {
        Resources.load();
        System.out.println("Loaded Scuccesfully");
        
    }

    @Override
    public void update() {
        setCurrentState(new MenuState());
        
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onCLick(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    

}
