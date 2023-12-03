/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superlinconbro;

import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Falling extends MarioState{
    public Falling(Mario mario) {
        super(States.FALLING,mario);
    }

    @Override
    public void enter() {
      
        this.mario.setFramex(5);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(1);
        this.mario.setMinFrame(5);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        if(this.mario.onGround()!=0){
            this.mario.setState(States.RUNNING.label, 1);
            this.mario.speedy = 0;
        }
        
    }
    
}
