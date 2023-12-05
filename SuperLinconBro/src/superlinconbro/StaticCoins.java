
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
    private static final int xE = 50;
    private static final int yE = 50;
    

    
    public StaticCoins(int x, int y, GameLoop game) throws IOException{
        this.setX(x);
        this.setY(y);
        this.setWidth(32);
        this.setHeight(32);
        this.setImage(path);
        this.game = game;
        new Mario(game);
    }
    
    public void update(int cameraX, int cameraY){
        collision();
        this.setX(this.getX()+ cameraX);
        this.setY(this.getY()+ cameraY);
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
        g.drawString("X " + this.getCounter(), xE + 32,yE+21);
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
        this.game.getMario().getX() + this.game.getMario().getWidth() > this.getX() &&
        this.game.getMario().getX() < this.getX() + this.getWidth()){
        if(this.isVisible()) {this.incrementCounter();}
        this.setVisible(false);
    }

    // Colisão pela esquerda
    if (this.game.getMario().getX() < this.getX() + this.getWidth() &&
        this.game.getMario().getX() >= this.getX() &&
        this.game.getMario().getY() + this.game.getMario().getHeight() > this.getY() &&
        this.game.getMario().getY() < this.getY() + this.getHeight()) {
        if(this.isVisible()) {this.incrementCounter();}
        this.setVisible(false);
    }

    // Colisão pela direita
    if (this.game.getMario().getX() + this.game.getMario().getWidth() > this.getX() &&
        this.game.getMario().getX() < this.getX() + this.getWidth()&&
        this.game.getMario().getY() + this.game.getMario().getHeight() > this.getY() &&
        this.game.getMario().getY() < this.getY() + this.getHeight()) {
        if(this.isVisible()) {this.incrementCounter();}
        this.setVisible(false);
    }

    // Colisão por baixo
    if (this.game.getMario().getX() + this.game.getMario().getWidth() > this.getX() &&
        this.game.getMario().getX() < this.getX() + this.getWidth() &&
        this.game.getMario().getY() < this.getY() + this.getHeight() &&
        this.game.getMario().getY() >= this.getY()) {
        if(this.isVisible()) {this.incrementCounter();}
        this.setVisible(false);
    }
    }
    
}