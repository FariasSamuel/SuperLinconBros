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
        
        String path = new File("src/Sprites/Koopa.png").getAbsolutePath();
        this.setImage(ImageIO.read(new File(path)));
    }


    
    @Override
    public void draw(Graphics g){
           int startX = this.getFramex()* (150 + 60);
        int startY = this.getFramey() * 240;
        int endX = (this.getFramex() + 1) * (150 + 60) - 60;
        int endY = (this.getFramey() + 1) * 240;

        g.drawImage(
            this.getImage(),
            this.getX(),
            this.getY(),
            this.getX() + this.getWidth(),
            this.getY() + this.getHeight(),
            startX, startY, endX, endY,
            null
        );
    }
    
    @Override
    public void update(int speed, int speedy, int time, double deltaTime) {
        this.setX(this.getX()-this.getSpeed());
        this.setY(this.getY()-this.speedy + this.getSpeed());
        this.setOriginY(this.getOriginY()-this.speedy);
        
        if(this.getOriginY() - this.getY() > 200){
            this.setSpeed(-5);
            
            if(this.getMario().getX() + this.getGame().getCameraX() > this.getX()+ this.getGame().getCameraX() - 400){
                this.setFramey(0) ;
            } 
            else{
                this.setFramey(3);
            }
        }else if(this.getOriginY() - this.getY() < 1){
            this.setSpeed(5);
            
            if(this.getMario().getX() + this.getGame().getCameraX() > this.getX()+ this.getGame().getCameraX() - 400){
                this.setFramey(1);
            }else{
                this.setFramey(4);
            }
        }
        this.setMaxFrame(3);
        this.setFramex(0);
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
