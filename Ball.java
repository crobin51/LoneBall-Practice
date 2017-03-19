package com.crobin.game.model;

import java.awt.Rectangle;

import com.crobin.game.main.GameMain;
import com.crobin.game.main.Resources;
import com.crobin.gramework.util.RandomNumberGenerator;

public class Ball {
    private int x, y, width, height, velX, velY;
    private Rectangle rect;
    
    public Ball(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        velX = 5;
        velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
        rect = new Rectangle(x, y, width, height);
    }
    
    public void update(){
        x+= velX;
        y+= velY;
        correctYcollisions();
        updateRect();
    }

    private void updateRect() {
       rect.setBounds(x, y, width, height);
        
    }

    private void correctYcollisions() {
        if(y< 0){
            y = 0;
        }else if(y+height > GameMain.GAME_HEIGHT){
            y= GameMain.GAME_HEIGHT - height;
        }else{
            return;
        }
        
        velY = -velY;
        Resources.bounce.play();
        
    }
    
    public void onCollideWith(Paddle p){
        if(x<GameMain.GAME_WIDTH/2){
            x = p.getX() + p.getWidth();
        }else{
            x = p.getX() - width;
        }
        
        velX = -velX;
        velY += RandomNumberGenerator.getRandIntBetween(-2, 3);
    }
    
    public boolean isDead(){
        return(x<0 || x + width >GameMain.GAME_WIDTH);
    }
    
    public void reset(){
        x = 300;
        y = 400;
        velX = 5;
        velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
    }
    
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public Rectangle getRect(){
        return rect;
    }

}
