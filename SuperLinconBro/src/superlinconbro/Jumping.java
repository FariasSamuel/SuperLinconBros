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
        if(this.mario.onGround()) 
            this.mario.speedy -= 30;
        this.mario.setFramex(5);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(1);
        this.mario.setMinFrame(5);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        this.mario.speedy += this.mario.weight;
        if(this.mario.onGround()){
            this.mario.setState(States.IDLE.label, 1);
            this.mario.speedy = 0;
        }
        
    }
    
}
