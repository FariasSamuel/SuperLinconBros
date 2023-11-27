package superlinconbro;

/**
 *
 * @author hubert
 */

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.cos;

public class Coins extends AbstractCoins{
    private GameLoop game;
    private final int position[] = {0,28,60,88};
    public Coins (int x, int y) throws IOException {
        this.setX(x);
        this.setY(y);
        this.setWidth(32);
        this.setHeight(32);
        this.setMaxFrame(4);
        this.setMinFrame(0);
        this.setFramex(0);
        this.setFramey(0);
        this.setFrameInterval(60);
        this.setFrameTimer(0);
        String path = new File("src/Sprites/items.png").getAbsolutePath();
        this.setImage(path);
        System.out.println(path);
    }
    
    @Override
    public void update (){
        animation(60); 
    }
    
    @Override
    public void draw(Graphics g) {
        
        g.drawImage(this.getImage(), 
                this.getX(), 
                this.getY(), 
                this.getX()+this.getWidth(), 
                this.getY()+this.getHeight(),
                this.position[this.getFramex()],
                0,
                this.position[this.getFramex()] + 10,
                16,
                game);
    }
  
    public void animation(double deltatime) {
        if (this.getFrameTimer() > this.getFrameInterval()) {
            this.setFrameTimer(0);
            
            if (this.getFramex() < this.getMaxFrame() - 1){
                this.setFramex(this.getFramex() + 1);
            } else {
                this.setFramex(this.getMinFrame());
            }
        } else {
            this.setFrameTimer(this.getFrameTimer() + deltatime);
        }  
        long currentTimeMillis = System.currentTimeMillis();
        this.setY( 20*(int)cos(currentTimeMillis));
    }

}
