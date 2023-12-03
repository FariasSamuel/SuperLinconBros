package superlinconbro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Sliding extends MarioState{

   public Sliding(Mario mario) {
        super(States.SLIDING,mario);
    }

    @Override
    public void enter() {
        this.mario.setFramex(4);
        this.mario.setFramey(0);
        this.mario.setMaxFrame(4);
        this.mario.setMinFrame(4);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        if(this.mario.speedx == 0){
            this.mario.setState(States.IDLE.label,0);
        }else if(input.contains(39)|| input.contains(37)){
           // System.out.println(this.mario.currentState);
            this.mario.setState(States.RUNNING.label,1);
        }
    }
  
}
