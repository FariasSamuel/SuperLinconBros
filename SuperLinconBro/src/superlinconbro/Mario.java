package superlinconbro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
    SLIDING(2),
    JUMPING(3) ,
    DYING(4) ,
    FALLING(5) ,
    SITTING(6) ,
    CLIMBING(7) ,
    ATTACKING(8) ,
    BALL(9);
    
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
    public int speedx;
    public int speedy;

    private float framex;
    private float framey;
    private int maxFrame;

    private int lastkey;
    private boolean grow;
    
    public float getMinFrame() {
        return minFrame;
    }

    public void setMinFrame(float minFrame) {
        this.minFrame = minFrame;
    }
    private float minFrame;
    private int fps;
    private double frameInterval;
    private double frameTimer;   
    private ArrayList<MarioState> states;
    public MarioState currentState;
    public int weight;
    public GameLoop game;
    public Mario(GameLoop game) throws IOException {
        this.game = game;
        this.width = 64;
        this.height = 64;
        this.x = 0;
        this.y = 452;

        this.speedx = 0;
        this.speedy = 0;
        this.weight = 4;
        this.framex = 0;
        this.framey = 32;
        this.minFrame =0;
        this.maxFrame = 1;
        this.fps = 0;
        this.frameInterval = 100;
        this.frameTimer = 0;
        this.grow = false;
        this.states = new ArrayList<MarioState>();
        this.states.add(new Idle(this));
        this.states.add(new Running(this));
        this.states.add(new Sliding(this));
        this.states.add(new Jumping(this));
        this.states.add(new DYING(this));
        this.states.add(new Falling(this));
        this.currentState = this.states.get(0);
        this.currentState.enter();
        String path = new File("src/Sprites/metademario.png").getAbsolutePath();
        image = ImageIO.read(new File(path));
        System.out.println(path);
    }

    public int getSpeedy(){
        return speedy;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(ArrayList<Integer> input, double deltaTime){
        this.currentState.handleInput(input);
        this.x += this.speedx;
        this.y += this.speedy;
        
        this.game.tiles.forEach((tile) -> {
        if (
          this.x + this.width > tile.getX() +10 &&
          this.x + this.width < tile.getX() + 30 &&
          this.y + this.height -15 >= tile.getY() &&
          this.y < tile.getY() + tile.getHeight()){
            this.x = tile.getX() - this.width +10;
        }
        if (
          this.x < tile.getX()+this.getWidth()-10 &&
          this.x > tile.getX()+this.getWidth()-30 &&
          this.y + this.height - 15>= tile.getY() &&
          this.y < tile.getY() + tile.getHeight()
        )
          this.x = tile.getX() + tile.getWidth() ; 
        
        
      });
        
        if (input.contains(39)) {
            this.speedx = 10;
            this.lastkey = 39;

        } else if (input.contains(37)) {
          this.speedx = -10;
          this.lastkey = 37;
        }else {
            this.speedx=0;
        }
       
        if(this.x < 0){
         this.x = 0;   
        }
            
        if (this.x > (this.game.width - this.width + 30) / 2) {
          this.x = (this.game.width - this.width + 30) / 2;
          this.game.setCameraX(this.game.getCameraX()-1);
        }else{
            this.game.setCameraX(0);
        }
    
        int DistanceToGround = onGround();
        System.out.println("D:"+DistanceToGround + " Y:" + (this.y + this.height));
     
        if (DistanceToGround == 0) {
            if (this.y + this.height > 480) {
             this.y = 480 - this.height;
            } else {
              this.speedy += 2;
            }
          } else  {
            this.speedy = 0;
            this.y = DistanceToGround - this.height + 10;
         }
        if(input.contains(65)){
            this.setState(States.DYING.label,1);
        }
      
        this.animation(60);
    }
    
    public void animation(double deltaTime){
    if (this.frameTimer > this.frameInterval) {
      this.frameTimer = 0;
      if (this.framex < this.maxFrame - 1){
       this.framex++;
      }
      else{
        this.framex = this.minFrame;
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
    float fxb = 0,fxe = 0;
    float fyb = 0,fye = 0;
    if(this.grow){
        fye = this.framey * 16 + 24  + 64;
        fyb = this.framey * 16 + 50;
        fxb =this.framex*32 - 8;
        fxe = this.framex*32 + 24;
    }else{
        fye = this.framey * 16 + 24;
        fyb = this.framey * 16;
        fxb =this.framex*32 ;
        fxe = this.framex*32 + 28;
    }
    
    if(this.lastkey == 39){
       
    g.drawImage(
      this.image,
   this.x,
      this.y,
      this.x+this.width ,
      this.y+this.height,
      (int)fxb,
      (int)fyb,
      (int)fxe,
      (int)fye,
      null
    );
    }else if(this.lastkey == 37){
    g.drawImage(
      this.image,
      this.x+this.width ,
      this.y,
      this.x ,
      this.y + this.height,
      (int)fxb,
      (int)fyb,
      (int)fxe,
      (int)fye,
      null
    );
    }
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

    public float getFramex() {
        return framex;
    }

    public void setFramex(float framex) {
        this.framex = framex;
    }

    public float getFramey() {
        return framey;
    }

    public void setFramey(float framey) {
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
    
    public void setGrow(boolean g){
        if(!g){
            this.grow = false;
            this.height = 64;
            this.width = 64;
        }else{
            this.grow = true;
            this.height = 96;
            this.width = 96;
        }
    }
    
    public int onGround(){
        int distance = 0;        
        for(Tile tile: this.game.tiles){
          if (
            this.x + this.width > tile.getX()+ 20 &&
            this.x < tile.getX()+tile.getWidth() - 20 &&
            this.y + this.height + this.speedy >= tile.getY() +10 &&
            this.y + this.height + this.speedy < tile.getY() + tile.getHeight()){
               distance = tile.getY();
            } 
        }
        
        return distance;
    }
}
