package com.crobin.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.font.*;

import com.crobin.game.main.GameMain;
import com.crobin.game.main.Resources;
import com.crobin.game.model.Ball;
import com.crobin.game.model.Paddle;

public class PlayState extends State{
    private Paddle paddleLeft, paddleRight;
    private static final int PADDLE_WIDTH = 15;
    private static final int PADDLE_HEIGHT = 60;
    private int playerScore = 0;
    private Font scoreFont;
    
    private Ball ball;
    private static final int BALL_DIAMETER = 20;
    
    @Override
    public void init() {
        paddleLeft = new Paddle(0, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddleRight = new Paddle(785, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
        scoreFont = new Font("SansSerif", Font.BOLD, 25);
        ball = new Ball(300, 200, BALL_DIAMETER, BALL_DIAMETER);
        
    }

    @Override
    public void update() {
       paddleLeft.update();
       paddleRight.update();
       ball.update();
       
       if(ballCollides(paddleLeft)){
           playerScore++;
           ball.onCollideWith(paddleLeft);
           Resources.hit.play();
           
       }else if (ballCollides(paddleRight)){
           playerScore++;
           ball.onCollideWith(paddleRight);
           Resources.hit.play();
       }else if(ball.isDead()){
           playerScore-=3;
           ball.reset();
       }
      
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Resources.darkBlue);
        g.fillRect(0, 0, GameMain.GAME_HEIGHT, GameMain.GAME_WIDTH);
        g.setColor(Resources.darkRed);
        g.fillRect(GameMain.GAME_WIDTH /2, 0, GameMain.GAME_WIDTH/2, GameMain.GAME_HEIGHT);
        
        
        
        g.drawImage(Resources.line, 398, 0, null);
        
        g.setColor(Color.white);
        g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
        g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());
        
        g.drawRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        
        g.setFont(scoreFont);
        g.drawString(""+ playerScore, 350, 40);
        
      
        
    }

    @Override
    public void onCLick(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            paddleLeft.accelUp();
            paddleRight.accelDown();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleLeft.accelDown();
            paddleRight.accelUp();
        }
        
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleLeft.stop();
            paddleRight.stop();
        }
        
    }
    
    private boolean ballCollides(Paddle p){
        return ball.getRect().intersects(p.getRect());
    }
    

}
