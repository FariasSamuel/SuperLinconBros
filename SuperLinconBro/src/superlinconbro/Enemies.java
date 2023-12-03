package superlinconbro;

import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.IOException;

/**
 *
 * @author Mateus
 */
public abstract class Enemies {
    private int x, y;
    private int width, height;
    private GameLoop game;
    private int speed;
    private boolean marked;
    private int lastAttack;
    private double range;
    private int framex, framey;
    private int originY;
    private BufferedImage image;
    private int maxFrame;
    private int fps;
    private int frameInterval, frameTimer;
    private Mario mario;

    public Enemies() throws IOException {
        this.mario = new Mario(game);
    }

    public abstract void update(int speed, int speedy, int time, double deltaTime);

    public abstract void collision();

    public void animation(double deltaTime) {
        if (this.frameTimer > this.frameInterval) {
            this.frameTimer = 0;
            if (this.framex < this.maxFrame - 1) {
                this.framex++;
            } else {
                this.framex = 0;
            }
        } else {
            this.frameTimer += deltaTime;
        }
    }

    public abstract void draw(Graphics g);

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

    public GameLoop getGame() {
        return game;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isMarked() {
        return marked;
    }

    public int getLastAttack() {
        return lastAttack;
    }

    public double getRange() {
        return range;
    }

    public int getFramex() {
        return framex;
    }

    public int getFramey() {
        return framey;
    }
    

    public int getOriginY() {
        return originY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getMaxFrame() {
        return maxFrame;
    }

    public int getFps() {
        return fps;
    }

    public int getFrameInterval() {
        return frameInterval;
    }

    public int getFrameTimer() {
        return frameTimer;
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

    public void setGame(GameLoop game) {
        this.game = game;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public void setLastAttack(int lastAttack) {
        this.lastAttack = lastAttack;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setFramex(int framex) {
        this.framex = framex;
    }

    public void setFramey(int framey) {
        this.framey = framey;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setMaxFrame(int maxFrame) {
        this.maxFrame = maxFrame;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public void setFrameInterval(int frameInterval) {
        this.frameInterval = frameInterval;
    }

    public void setFrameTimer(int frameTimer) {
        this.frameTimer = frameTimer;
    }
    
    public Mario getMario(){
        return this.mario;
    }
    
}
