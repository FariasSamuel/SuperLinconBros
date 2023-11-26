package superlinconbro;

import superlinconbro.GameLoop;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.cos;
import javax.imageio.ImageIO;

public class Coins extends AbstractCoins{
    private GameLoop game;
    private int posicao[] = {0,28,60,88};
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
    public void update (){
        animation(60);
        //this.setY((int) (this.getY()+ (this.getSpeedy() * this.getDeltaTime()))); 
    }
    @Override
    public void draw(Graphics g) {
        
        g.drawImage(this.getImage(), 
                this.getX(), 
                this.getY(), 
                this.getX()+this.getWidth(), 
                this.getY()+this.getHeight(),
                this.posicao[this.getFramex()],
                0,
                this.posicao[this.getFramex()] + 10,
                16,
                game);
    }
    public void incrementCounter() {
        counter++;
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
