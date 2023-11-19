package Sprites;

import java.util.Vector;

import superlinconbro.GameLoop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Koopa extends Enemies{

    private int lastShoot;
    private char lastKey;


    @Override
    public void update() {
    }

    @Override
    public void update(int speed, int speedy, int time, double deltaTime) {
        //TODO
        this.setX(this.getX()-speed);
        this.setY(this.getY()-speedy + this.getSpeed());
        this.setOriginY(this.getOriginY()-speedy);

        if(this.getOriginY() - this.getY() > 200){
            this.setSpeed(-5);
       //     (this.getGame().getPlayer().getX() + this.getGame().getCameraX() > this.getX() + this.getGame().getCameraX() - 400)?this.getFramey() == 0 : this.setFramey(3);
        }else if(this.getOriginY()- this.getY() < 1){
            this.setSpeed(5);
        //    (this.getGame().player.getX() + this.getGame().CameraX > this.getX() + this.getGame().CameraX - 400)?this.getFramey() == 1 : this.setFramey(4);
        }
        this.setMaxFrame(3);;
        this.setFramex(0);
       // this.colision();
        this.animation(deltaTime);
       // this.attack(time, deltaTime);
    }


}
