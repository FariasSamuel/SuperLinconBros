package superlinconbro;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samuelfarias
 */
public class Jumping extends MarioState{
    public Jumping(Mario mario) {
        super(States.JUMPING,mario);
    }

    @Override
    public void enter() {
        if(this.mario.onGround() != 0){
            this.mario.speedy -= 40;
            for(Tile tile: this.mario.game.tiles) {
                if (
                  (this.mario.getX() + this.mario.getWidth()- 15 > tile.getX() &&
                  this.mario.getX() +15< tile.getX()+ tile.getWidth()  &&
                  this.mario.getY() + this.mario.getHeight()-15 > tile.getY() &&
                  this.mario.getY() + this.mario.speedy < tile.getY() + tile.getHeight())){
                    this.mario.speedy -=  tile.getY() + tile.getHeight() - this.mario.getY();
                }
            }
        }
        this.mario.setFramex(5);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(1);
        this.mario.setMinFrame(5);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        this.mario.speedy += this.mario.weight;
        if(this.mario.onGround() !=0){
            this.mario.setState(States.IDLE.label, 1);
            this.mario.speedy = 0;
        }
        this.mario.game.tiles.forEach(tile->{
            if((this.mario.getX() + this.mario.getWidth() > tile.getX() + 30 && this.mario.getX() < tile.getX() + tile.getWidth() - 30) && (this.mario.getY() + 10  < tile.getY() + tile.getHeight() && this.mario.getY() + this.mario.getHeight() >= tile.getY() - 10)){
                //console.log("True")
                this.mario.speedy = this.mario.weight;  
                this.mario.setState(States.RUNNING.label,1);
            }
        });
    }

}
