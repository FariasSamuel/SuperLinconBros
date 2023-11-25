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
enum States  {
    IDLE(0),
    RUNNING(1),
    SLIDING(2),
    JUMPING(3) ,
    DEADING(4) ,
    ATTACKING(5) ,
    SITTING(6) ,
    CLIMBING(7) ,
    FALLING(8) ,
    BALL(9);
    
    public final int label;

    private States(int label) {
        this.label = label;
    }
}
public abstract class MarioState {
    public States state;
    public Mario mario;
    public MarioState(States state,Mario mario){
        this.state = state;
        this.mario = mario;
    }
    public States getState(){
        return this.state;
    }
    public abstract void enter();
    public abstract void handleInput(ArrayList<Integer> input);
}

