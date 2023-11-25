package superlinconbro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
class Idle extends MarioState{
    public Idle(Mario mario){
        super(States.IDLE,mario);
    }
    @Override
    public void enter() {
        //if(this.mario.onGround()) 
        //    this.mario.vy -= 20;
        this.mario.setFramex(0);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(1);
        this.mario.setMinFrame(0);
    }
    @Override
    public void handleInput(ArrayList<Integer> input) {
        if(input.contains(39)|| input.contains(37)){
            this.mario.setState(States.RUNNING.label,1);
        }
        if(input.contains(38)){
            this.mario.setState(States.JUMPING.label,1);
        }
    }
}