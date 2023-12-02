
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


public class StaticCoins extends AbstractItems{
    private GameLoop game;
    private final String path = new File("src/Sprites/coins.png").getAbsolutePath();
    private Mario mario;
    public static int counter;
    private static final int xE = 50;
    private static final int yE = 50;
    
    public void incrementCounter(){
        counter++;
    }
    
    
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
        g.drawString("X " + counter, xE + 32,yE+21);
        g.drawImage(this.getImage(), 
                 xE,
                 yE, 
                 xE + this.getWidth(),
                 yE + this.getHeight(),
                 0, 0,
                 10, 16,game);
        }

    public void collision(){
      // Colisão por cima
    if (this.game.getMario().getY() < this.getY() + this.getHeight() &&
        this.game.getMario().getY() + this.game.getMario().getSpeedy() >= this.getY() &&
        this.mario.getX() + this.mario.getWidth() > this.getX() &&
        this.mario.getX() < this.getX() + this.getWidth() &&
        this.mario.currentState.getState() != States.DYING) {
        this.setVisible(false);
        this.incrementCounter();
    }

    // Colisão pela esquerda
    if (this.mario.getX() < this.getX() + this.getWidth() &&
        this.mario.getX() >= this.getX() &&
        this.mario.getY() + this.mario.getHeight() > this.getY() &&
        this.mario.getY() < this.getY() + this.getHeight() &&
        this.mario.currentState.getState() != States.DYING) {
        this.setVisible(false);
        this.incrementCounter();
    }

    // Colisão pela direita
    if (this.mario.getX() + this.mario.getWidth() > this.getX() &&
        this.mario.getX() < this.getX() + this.getWidth() &&
        this.mario.getY() + this.mario.getHeight() > this.getY() &&
        this.mario.getY() < this.getY() + this.getHeight() &&
        this.mario.currentState.getState() != States.DYING) {
        this.setVisible(false);
        this.incrementCounter();
    }

    // Colisão por baixo
    if (this.mario.getX() + this.mario.getWidth() > this.getX() &&
        this.mario.getX() < this.getX() + this.getWidth() &&
        this.mario.getY() < this.getY() + this.getHeight() &&
        this.mario.getY() >= this.getY() &&
        this.mario.currentState.getState() != States.DYING) {
        this.setVisible(false);
        this.incrementCounter();
}


    }
    
}
