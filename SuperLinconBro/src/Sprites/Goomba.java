package Sprites;

import superlinconbro.GameLoop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Goomba extends Enemies{

    private Random random = new Random();
    private int previousState;
    private int followingState;
    private int vy, vx;
    private int weight;
    private int originX;
    private int direction;

    public Goomba (int x, int y, int width, int height, int direction, GameLoop game, int range) throws IOException {
        this.setX(x);
        this.setY(y);
        this.setWidth(90);
        this.setHeight(90);
        this.setGame(game);
        this.setRange(range);
        this.setSpeed(0);
        this.setMarked(false);
        this.setLastAttack(0);
        previousState = 0;
        followingState = 1;
        vy = 0;
        vx = -2;
        weight = 1;
        this.setOriginY(y);
        originX = x;
        this.setRange(range);
        this.setFramex(0);
        this.setFramey(0);
        this.setMaxFrame(2);
        this.setFps(5);
        this.setFrameInterval(1000/this.getFps());
        this.setFrameTimer(0);
        String path = new File("src/Sprites/goomba.png").getAbsolutePath();
        this.setImage(ImageIO.read(new File(path)));

        this.direction = random.nextInt(2);

        switch(direction){
            case 0:
                vx = -2;

                break;
            case 1:
                vx = 2;
                break;
        }
    }

    @Override
    public void update() { }

    @Override
    public void update(int speed, int speedy, int time, double deltaTime) {

        this.setX(this.getX() - speed + this.getSpeed());
        this.setY(this.getY() - speedy - vy);

        this.setOriginY(this.getOriginY() - speedy);


        //Gravidade
        vy += 5;
        this.setY(this.getY() + 5);

        //Fazer com que ele volte para o chao
        if(!this.isMarked()){
            if(this.getY()>this.getOriginY()){
                vy = 0;
                this.setY(getOriginY());
            }


        }
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        Color brown = new Color(139, 69, 19);
        g.setColor(brown);
    }

    public void animation(double deltaTime){
    }

    public void collison(){
    }

}
