package superlinconbro;

import superlinconbro.Enemies;

import java.io.IOException;

import superlinconbro.GameLoop;
import superlinconbro.Mario;
import superlinconbro.States;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mateus
 */
public class Koopa extends Enemies {

    private int lastShoot;
    
    private int speedy;
    
    private char lastKey;

    public Koopa() throws IOException {
    }


    
    @Override
    public void draw(Graphics g){
           
    }
    @Override
    public void update(int speed, int speedy, int time, double deltaTime) {
        this.setX(this.getX()-this.getSpeed());
        this.setY(this.getY()-this.speedy + this.getSpeed());
        this.setOriginY(this.getOriginY()-this.speedy);
        
        
        
        
        this.collision();
        this.animation(deltaTime);
        this.attack(time, deltaTime);
    }
    
    public void collision(){
        if (this.getMario().getX() + this.getMario().getWidth() > this.getX() + 30 &&
                this.getMario().getX() + this.getMario().getWidth() < this.getX() + 40 &&
                this.getMario().getY() + this.getMario().getHeight() >= this.getY() &&
                this.getMario().getY() < this.getY() + this.getHeight() &&
                this.getMario().currentState.getState() != States.DYING) {
            this.getMario().setState(4, 0);
        }
        if (this.getMario().getX() < this.getX() + this.getWidth() - 30 &&
                this.getMario().getX() > this.getX() + this.getWidth() - 40 &&
                this.getMario().getY() + this.getMario().getHeight() >= this.getY() &&
                this.getMario().getY() < this.getY() + this.getHeight() &&
                this.getMario().currentState.getState() != States.DYING) {
            this.getMario().setState(4, 0);
        }
        if (this.getMario().getX() + this.getMario().getWidth() > this.getX() + 30 &&
                this.getMario().getX() < this.getX() + this.getWidth() - 30 &&
                this.getMario().getY() + this.getMario().getHeight() + this.getMario().getSpeedy() >= this.getY() &&
                this.getMario().getY() + this.getMario().getHeight() + this.getMario().getSpeedy() < this.getY() + this.getHeight()) {
            this.isMarked(true);
        }
    }
    
    public void animation(double deltaTime){
        super.animation(deltaTime);
    }
    
    public void attack(int time, double deltaTime){
        
    }
}
