package superlinconbro;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hubert
 */
public class MysteryBox {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private int framex;
    private final int maxFrame;
    private final int minFrame;
    private final double frameInterval;
    private double frameTimer;
    private final BufferedImage image;
    private GameLoop game;
    private final int position[] = {0,30,60};
    private boolean visible = true;
    
    public MysteryBox(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        width = 32;
        height = 32;
        maxFrame = 3;
        minFrame = 0;
        framex = 0;
        frameInterval = 60;
        frameTimer = 0;
        String path = new File("src/Sprites/mysterybox.png").getAbsolutePath();
        image =  ImageIO.read(new File(path));       
    }
    
    public void update(Mario mario, StaticCoins staticCoin){
        animation(60);
        collision(mario, staticCoin);
    }
    
    public void draw (Graphics g) {
       if(visible){ g.drawImage(image,
                x, y,
                x + width, y + height,
                position[framex], 0,
                position[framex] + 16, 16,
                game);
        }
    }
    
    public void animation(double deltaTime){
            if (frameTimer > frameInterval) {
                frameTimer = 0;
            if (framex < maxFrame - 1) {
                framex += 1;
            } else {
                framex = minFrame;
            }
        } else {
            frameTimer += deltaTime;
        }
    }
    
    public void collision(Mario mario, StaticCoins staticCoin) {
        if (mario.getX() + mario.getWidth() > x + 60 &&
        mario.getX() < x + width - 60 &&
        mario.getY() < y + height &&
        mario.getY() + mario.getSpeedy() >= y &&
        mario.currentState.getState() != States.DYING) { 
        visible = false;
        //this.incrementCounter();
        }
    }
}
