package com.crobin.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.crobin.game.main.Resources;

public class MenuState extends State {

    @Override
    public void init() {
        System.out.println("entered MenuState");

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.welcome, 0, 0, null);
        // g.drawImage(Resources.iconimage, 400, 200, null);

    }

    @Override
    public void onCLick(MouseEvent e) {
     //   System.out.println("Clicked");
        setCurrentState(new PlayState());
    }

    @Override
    public void onKeyPress(KeyEvent e) {
     //   System.out.println("Pressed");

    }

    @Override
    public void onKeyRelease(KeyEvent e) {
      //  System.out.println("Released");

    }

}
