package superlinconbro;

/**
 *
 * @author hubert
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class AbstractCoins {
    private int width;
    private int height;
    private int x;
    private int y;
    private static final int xE = 20;
    private static final int yE = 50;
    private int maxFrame;
    private int minFrame;
    private int framex;
    private int framey;
    private double deltaTime;
    private double frameInterval;
    private double frameTimer;
    public static int counter;
    private BufferedImage image;
    private boolean visible = true;
    
    public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }
    
    public void incrementCounter(){
        counter++;
    }
    
    public void update(){
        
    }
    
    public int getX() {
        return x;
}
    public int getY() {
        return y;
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
    public boolean isVisible(){
        return visible;
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
    public void setVisible(boolean visible){
        this.visible = visible;
    }
}

