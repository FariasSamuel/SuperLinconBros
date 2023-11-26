package superlinconbro;


import superlinconbro.GameLoop;
import superlinconbro.Mario;
import superlinconbro.States;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Goomba extends Enemies {
    private int previousState;
    private int followingState;
    private int vy, vx;
    private final int weight;
    private int originX;
    private int direction;
    //private Mario mario;

    public Goomba (int x, int y, int width, int height, int direction, GameLoop game, int range, Mario mario) throws IOException {
        super();
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setGame(game);
        this.setRange(range);
        this.setSpeed(0);
        this.setMarked(false);
        this.setLastAttack(0);
        this.previousState = 0;
        this.followingState = 1;
        this.vy = 0;
        this.vx = -2;
        this.weight = 1;
        this.setOriginY(y);
        this.originX = x;
        this.setRange(range);
        this.setFramex(0);
        this.setFramey(0);
        this.setMaxFrame(2);
        this.setFps(5);
        this.setFrameInterval(1000/this.getFps());
        this.setFrameTimer(0);
        String path = new File("src/Sprites/goomba.png").getAbsolutePath();
        this.setImage(ImageIO.read(new File(path)));
        //this.mario = new Mario(super.getGame());
        }

    @Override
    public void update(int speed, int speedy, int time, double deltaTime) {
        this.setX(this.getX() - speed + this.getSpeed());
        this.setY(this.getY() - speedy - vy);

        this.setOriginY(this.getOriginY() - speedy);

        if(this.previousState == 0){
            if((time/1000) - this.getLastAttack() >= this.getRange()){
                this.setFramey(0);
                this.setSpeed(0);
                this.previousState = this.followingState;
                this.followingState = 0;
                this.setLastAttack(time/1000);
            }
        }else{
            if((time/1000) - this.getLastAttack() >=1){
                this.setFramey(1);
                if(this.previousState == - 1){
                    this.setSpeed(-10*this.direction);
                    this.followingState = 1;
                    if(this.vy > this.getOriginY()){
                        this.vy = -15;
                    }
                }
                if(this.previousState == 1){
                  this.setSpeed(10*this.direction);
                  this.followingState = -1;
                }
                this.previousState = 0;
                this.setLastAttack(time/1000);
            }else if(this.getY() >= this.getOriginY()){
                this.vy = 0;
                this.setY(this.getOriginY());
            }
        }
        if(this.getY()<this.getOriginY()){
            this.vy += this.weight;
        }
        this.animation(deltaTime);
        this.collision();
    }

    public void collision(){
        super.collision();
    }

    public void animation(double deltaTime){
        super.animation(deltaTime);
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        Color brown = new Color(139, 69, 19);
        g.setColor(brown);
    }
}
