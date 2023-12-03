
package superlinconbro;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author hubert
 */
public class Mushroom extends AbstractItems{
    private int speed;
    private GameLoop game;
    private int direction;
    private Mario mario;
    
    public Mushroom(int x, int y, int direction) throws IOException{
        this.setX(x);
        this.setY(y);
        this.direction = direction;
        this.setWidth(32);
        this.setHeight(32);
        this.setFramex(0);
        this.setMinFrame(0);
        this.setMaxFrame(2);
        this.setFrameInterval(60);
        this.setFrameTimer(0);
        String path = new File("src/Sprites/mushroom.png").getAbsolutePath();
        this.setImage(path);
        System.out.println(path);
    }
    
    @Override
    public void update(){
    }
    
    @Override
    public void draw(Graphics g){
        g.drawImage(this.getImage(),
                this.getX(), this.getY(),
                this.getX() + this.getWidth(),
                this.getY() + this.getHeight(),
                this.getFramex(), 0,
                this.getFramex() * 16, 0,
                game);
    }
    
    public void animation(double deltaTime) {
        if (this.getFrameTimer() > this.getFrameInterval()) {
            this.setFrameTimer(0);

            if (this.getFramex() < this.getMaxFrame() - 1) {
                this.setFramex(this.getFramex() + 1);
            } else {
                this.setFramex(this.getMinFrame());
            }
        } else {
            this.setFrameTimer(this.getFrameTimer() + deltaTime);
        }
    }
    
    public void collision(){
        if (this.mario.getX() + this.mario.getWidth() > this.getX() + 60 &&
        this.mario.getX() < this.getX() + this.getWidth() - 60 &&
        this.mario.getY() < this.getY() + this.getHeight() &&
        this.mario.getY() + this.mario.getSpeedy() >= this.getY() &&
        this.mario.currentState.getState() != States.DYING) { 
        this.setVisible(false);
        }
    }
}
