package Sprites;

import superlinconbro.GameLoop;

public class Goomba extends Enemies{

    private int previousState;

    //private followingState
    private int vy, vx;
    private int weight;
    private int originX;
    private int direction;

    public Goomba(int x, int y, int width, int height, int direction, GameLoop game, int range) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.direction = direction;
        this.setGame(game);
        this.setRange(range);
        this.setSpeed(0);
        vy = 0;
        vx = -5;
        weight = 1;
        this.setOriginY(y);
        originX = x;
        direction = direction;
        this.setRange(range);
        this.setFramex(0);
        this.setFramey(0);
        //colocar a string da imagem
        //this.setImage();
        this.setMaxFrame(2);
        this.setFps(5);
        this.setFrameInterval(1000/this.getFps());
        this.setFrameTimer(0);
    }

    @Override
    public void update() { }

    @Override
    public void update(int speed, int speedy, int time, int deltaTime) {

        this.setX(this.getX() - speed + this.getSpeed());
        this.setY(this.getY() - speedy - vy);

        this.setOriginY(this.getOriginY() - speedy);


        //Gravidade
        //vy += 5;
       // this.setY(this.getY() + 5);

        //Fazer com que ele volte para o chao
        if(!this.isMarked()){
            if(this.getY()>this.getOriginY()){
                vy = 0;
                this.setY(getOriginY());
            }


        }
    }



}
