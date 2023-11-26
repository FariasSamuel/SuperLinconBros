package superlinconbro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huber
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import superlinconbro.GameLoop;

public abstract class AbstractCoins {
    private int width;
    private int height;
    private int x;
    private int y;
    private static final int speedy = 10;
    private static final int xE = 20;
    private static final int yE = 50;
    private int fps;
    private int maxFrame;
    private int minFrame;
    private int framex;
    private int framey;
    private double deltaTime;
    private double frameInterval;
    private double frameTimer;
    public static int counter;
    private BufferedImage image;
    
     public void collison(){
        //TODO
    }
    public void animation(){
        if (this.frameTimer > this.frameInterval) {
            this.frameTimer = 0;
            if (this.framex < this.maxFrame - 1){
                this.framex++;
            }
            else{
                this.framex = 0;
            }
        } else {
            this.frameTimer += this.deltaTime;
        }
    }
    public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }
    
    public int getX() {
        return x;
}
    public int getY() {
        return y;
    }
    public int getSpeedy () {
        return speedy;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getXE() {
        return xE;
    }
    public int getYE() {
        return yE;
    }
    public int getFps() {
        return fps;
    }
    public int getMaxFrame() {
        return maxFrame;
    }
    public int getMinFrame() {
        return minFrame;
    }
    public int getFramex() {
        return framex;
    }
    public int getFramey() {
        return framey;
    }
    public double getDeltaTime() {
        return deltaTime;
    }
    public double getFrameInterval() {
        return frameInterval;
    }
    public double getFrameTimer() {
        return frameTimer;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setFps(int fps) {
        this.fps = fps;
    }
    public void setMaxFrame(int maxFrame) {
        this.maxFrame = maxFrame;
    }
    public void setMinFrame(int minFrame) {
        this.minFrame = minFrame;
    }
    public void setFramex(int framex) {
        this.framex = framex;
    }
    public void setFramey(int framey) {
        this.framey = framey;
    }
    public void setDeltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
    }
    public void setFrameInterval(double frameInterval) {
        this.frameInterval = frameInterval;
    }
    public void setFrameTimer(double frameTimer) {
        this.frameTimer = frameTimer;
    }
    public void setImage(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }
    /*  g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16)); 
        g.drawString("X" + counter, xe + 5, ye);*/
}

