package superlinconbro;

/**
 *
 * @author hubert
 */


import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.sin;

public class Coins extends AbstractItems{
    private GameLoop game;
    private final int position[] = {0,28,60,88};
    private final double amplitude = -50.0; // Amplitude da função senoidal
    private final double frequency = 2.0; // Frequência da função senoidal
    private double time = 0.0; 
    
    
    public Coins (int x, int y) throws IOException {
        this.setX(x);
        this.setY(y);
        this.setWidth(32);
        this.setHeight(32);
        this.setMaxFrame(4);
        this.setMinFrame(0);
        this.setFramex(0);
        this.setFrameInterval(60);
        this.setFrameTimer(0);
        String path = new File("src/Sprites/coins.png").getAbsolutePath();
        this.setImage(path);
        System.out.println(path);
    }
    
    @Override
    public void update (){
        animation(60); 
    }
    
    @Override
        
    public void draw(Graphics g) {
       if(this.isVisible()==true){ g.drawImage(this.getImage(),
                this.getX(),
                (int) (this.getY() + amplitude * sin(frequency * time)),
                this.getX() + this.getWidth(),
                (int) (this.getY() + this.getHeight() + amplitude * sin(frequency * time)),
                this.position[this.getFramex()],
                0,
                this.position[this.getFramex()] + 10,
                16,
                game);
       }
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
        this.time += deltaTime / 1000.0; // Converte deltaTime para segundos
    }

}