package superlinconbro;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Samuel
 */
public class DYING extends MarioState{
    public DYING(Mario mario) {
        super(States.DYING,mario);
    }

    @Override
    public void enter() {
         
        this.mario.speedy -= 30;
        this.mario.setFramex(5.5f);
        this.mario.setFramey(0.5f);
        this.mario.setMaxFrame(1);
        this.mario.setMinFrame(5.5f);
    }

    @Override
    public void handleInput(ArrayList<Integer> input) {
        this.mario.speedy += this.mario.weight;
        
        
    }
    
}