
package superlinconbro;

/**
 *
 * @author hubert
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;


public class StaticCoins extends AbstractCoins{
    private GameLoop game;
    private String path = new File("src/Sprites/coins.png").getAbsolutePath();
    private Mario mario;
    
    
    public StaticCoins(int x, int y) throws IOException{
        this.setX(x);
        this.setY(y);
        this.setWidth(32);
        this.setHeight(32);
        this.setImage(path);
        this.mario = new Mario(game);
    }
    
    @Override
    public void update(){
        collision();
    }
    @Override
    public void draw(Graphics g){
        if(this.isVisible()){g.drawImage(this.getImage(), 
                this.getX(),
                this.getY(), 
                 this.getX() + this.getWidth(),
                 this.getY() + this.getHeight(),
                 0, 0,
                 10, 16,game);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16)); 
        g.drawString("X" + counter, this.getXE() + 5,this.getYE());
        g.drawImage(this.getImage(), 
                 this.getXE(),
                 this.getYE(), 
                 this.getXE() + this.getWidth(),
                 this.getYE() + this.getHeight(),
                 0, 0,
                 10, 16,game);
        }

    public void collision(){
        if (this.mario.getX() + this.mario.getWidth() > this.getX() + 60 &&
        this.mario.getX() < this.getX() + this.getWidth() - 60 &&
        this.mario.getY() < this.getY() + this.getHeight() &&
        this.mario.getY() + this.mario.getSpeedy() >= this.getY() &&
        this.mario.currentState.getState() != States.DYING) { 
        this.setVisible(false);
        this.incrementCounter();
        }
    }
}
