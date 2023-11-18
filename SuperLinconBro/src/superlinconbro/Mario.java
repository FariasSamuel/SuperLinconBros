/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superlinconbro;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Samuel
 */

enum States  {
    IDLE(0),
    RUNNING(1),
    JUMPING(2) ,
    FALLING(3) ,
    ATTACKING(4) ,
    SITTING(5) ,
    CLIMBING(6) ,
    DEADING(7) ,
    BALL(8);
    
    public final int label;

    private States(int label) {
        this.label = label;
    }
}

public class Mario {
    private int width;
    private int height;
    //private Image image; 
    
    private int x;
    private int y;
    private BufferedImage image;
    private int speedx;
    private int speedy;

    private int framex;
    private int framey;
    private int maxFrame;
    private int fps;
    private double frameInterval;
    private double frameTimer;   
    private ArrayList<MarioState> states;
    private MarioState currentState;
     
    public Mario() throws IOException {
        this.width = 96;
        this.height = 96;
        this.x = 0;
        this.y = 0;
        this.speedx = 0;
        this.speedy = 0;
        this.framex = 0;
        this.framey = 0;
        this.maxFrame = 0;
        this.fps = 0;
        this.frameInterval = 0;
        this.frameTimer = 0;
        this.states = new ArrayList<MarioState>();
        this.states.add(new Idle(this));
        this.states.add(new Running(this));
        this.currentState = this.states.get(0);
        this.currentState.enter();
        String path = new File("src/Sprites/sprites.png").getAbsolutePath();
        image = ImageIO.read(new File(path));
        System.out.println(path);
    }

    public void move(ArrayList<Integer> input, double deltaTime){
        this.currentState.handleInput(input);
        this.x += this.speedx;
        this.y += this.speedy;
        
        if (input.contains(39)) {
            this.speedx = 20;
            
        } else if (input.contains(37)) {
          this.speedx = -20;
        }
        else {
          this.speedx = 0;
        }
        this.animation(deltaTime);
    }
    
    public void animation(double deltaTime){
    if (this.frameTimer > this.frameInterval) {
      this.frameTimer = 0;
      if (this.framex < this.maxFrame - 1){
       this.framex++;
      }
      else{
        this.framex = 0;
      } 
    } else {
      this.frameTimer += deltaTime;
    }
  }
    public void paint(Graphics g) { 
      
    int x = 0;
    if (this.speedx > 0) {
      x = this.x;
    } else if (this.speedx < 0) {
      x = (this.x + this.width) * -1;
    }

    /*g.drawImage(
      this.image,
      this.framex * 32,
      this.framey * 32 + 1,
      32,
      32,
      x,
      this.y,
      this.width,
      this.height
    );*/
    g.drawImage(
      this.image,
   x,
      this.y,
      this.width,
      this.height,
      this.framex * 32,
      this.framey * 32 + 1,
      32,
      32,
      null
    );
    //g.fillRect(this.x, this.y, this.width, this.height);
  }
    public int getMaxFrame() {
        return maxFrame;
    }

    public void setMaxFrame(int maxFrame) {
        this.maxFrame = maxFrame;
    }
    
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFramex() {
        return framex;
    }

    public void setFramex(int framex) {
        this.framex = framex;
    }

    public int getFramey() {
        return framey;
    }

    public void setFramey(int framey) {
        this.framey = framey;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public double getFrameInterval() {
        return frameInterval;
    }

    public void setFrameInterval(double frameInterval) {
        this.frameInterval = frameInterval;
    }

    public double getFrameTimer() {
        return frameTimer;
    }

    public void setFrameTimer(double frameTimer) {
        this.frameTimer = frameTimer;
    }
    
    public void setState(int state,int speed){
        if(state != this.currentState.state.label){
        this.currentState = this.states.get(state);
        this.currentState.enter();
        }
    }
    
    
}
