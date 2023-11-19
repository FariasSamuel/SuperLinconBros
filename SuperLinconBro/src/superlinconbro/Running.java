package superlinconbro;


import java.util.ArrayList;
import superlinconbro.Mario;
import superlinconbro.MarioState;
import superlinconbro.States;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Samuel
 */
public class Running extends MarioState{
    
    public Running(Mario mario) {
        super(States.RUNNING,mario);
    }

    @Override
    public void enter() {
        this.mario.setFramex(1);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(4);
        this.mario.setMinFrame(1);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        if(input.contains(39) == false && input.contains(37) == false){
            if(this.mario.speedx != 0)
                this.mario.setState(States.SLIDING.label,0);
            else
                this.mario.setState(States.RUNNING.label,0);
        }
    }
    
}
