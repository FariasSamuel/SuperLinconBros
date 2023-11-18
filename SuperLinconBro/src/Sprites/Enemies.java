package Sprites;

import java.awt.*;
import java.util.ArrayList;

public abstract class Enemies {
    private int x;
    private int y;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private boolean marked;
    private double lastAttack;
    private int range;
    private int framex;
    private int framey;
    private int originY;
    private String image;
    private int maxFrame;
    private int fps;
    private int frameInterval;
    private int frameTimer;

    //private Graphics graphics;

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

    public Game getGame() {
        return game;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isMarked() {
        return marked;
    }

    public double getLastAttack() {
        return lastAttack;
    }

    public int getRange() {
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

    public String getImage() {
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

    public void setGame(Game game) {
        this.game = game;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public void setLastAttack(double lastAttack) {
        this.lastAttack = lastAttack;
    }

    public void setRange(int range) {
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

    public void setImage(String image) {
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

    public abstract void update();

    public void collison(){

    }

    public void animation(int deltaTime){

    }

    public void draw(Graphics g){

    }

    public abstract void update(int speed, int speedy, int time, int deltaTime);
}
