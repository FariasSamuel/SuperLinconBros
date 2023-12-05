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
    private Coins coin;
    
    public MysteryBox(int x, int y, GameLoop game, Coins coin) throws IOException{
        this.x = x;
        this.y = y;
        width = 32;
        this.game = game;
        height = 32;
        maxFrame = 3;
        minFrame = 0;
        framex = 0;
        frameInterval = 60;
        frameTimer = 0;
        String path = new File("src/Sprites/mysterybox.png").getAbsolutePath();
        image =  ImageIO.read(new File(path));   
        this.coin = coin;
    }
    public void update(int cameraX, int cameraY) throws IOException{
        x += cameraX;
        y += cameraY;
        animation(60);
        if(visible) collision();
        else{
            this.coin.update(cameraX, cameraY);
        }
    }
    
    public void draw (Graphics g) {
       if(visible){ g.drawImage(image,
                x, y,
                x + width, y + height,
                position[framex], 0,
                position[framex] + 16, 16,
                game);
        }
       else{
           this.coin.draw(g);
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
    
    public void collision() throws IOException {
        // Colisão por baixo
        if (this.game.getMario().getX() + this.game.getMario().getWidth() > x &&
        this.game.getMario().getX() < x + width &&
        this.game.getMario().getY() < y + height &&
        this.game.getMario().getY() >= y) {
        visible = false;
        this.coin = new Coins(x, y-25, game);
    }
}
}

        
