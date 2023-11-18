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
enum States  {
    IDLE(0),
    RUNNING(1),
    JUMPING(2) ,
    FALLING(3) ,
    ATTACKING(4) ,
    SITTING(5) ,
    CLIMBING(6) ,
    DEADING(7) ,
    BALL(8);
    
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

