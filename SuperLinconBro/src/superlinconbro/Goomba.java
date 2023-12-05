package superlinconbro;


import superlinconbro.GameLoop;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mateus
 */
public class Goomba extends Enemies {
    private int vy, vx;
    private final int weight;
    private int direction;

    public Goomba (int x, int y, int width, int height, int direction, GameLoop game, double range) throws IOException {
        super(x, y, width, height, game);
        this.setRange(range);
        this.setSpeed(0);
        this.setMarked(false);
        this.setLastAttack(0);
        this.vy = 0;
        this.vx = 4;
        this.weight = 1;
        this.setOriginY(y);
        this.direction = direction;
        this.setRange(range);
        this.setFramex(0);
        this.setFramey(0);
        this.setMaxFrame(2);
        this.setFps(5);
        this.setFrameInterval(1000/5);
        this.setFrameTimer(0);
        String path = new File("src/Sprites/goomba.png").getAbsolutePath();
        this.setImage(ImageIO.read(new File(path)));
        this.setVisible(true);
    }

    @Override
    public void update(int speedx, int speedy, int time, double deltaTime) {
        
        
        this.setX(this.getX() + (vx * this.direction) + this.getSpeed());
        //this.setY(this.getY() - speedy - this.vy);
        
        this.setX(this.getX() + speedx);
        this.setY(this.getY() + speedy);

        this.setOriginY(this.getOriginY() - speedy);
        
        
        boolean collided = false;
        for(Tile tile: this.getGame().tiles) {
        if (
          (this.getX() +this.vx + this.getWidth()) - 15 > tile.getX() &&
          this.getX() + this.vx +15 < tile.getX() + tile.getWidth()  &&
          this.getY() + this.getHeight()-15 > tile.getY() &&
          this.getY()  < tile.getY() + tile.getHeight()){
            collided = true;
        }
        }
        if(collided) this.direction = this.direction*-1;
        
        int distanceToGround = onGround();
        if(distanceToGround > 0){
            this.vy = -10;
            this.vx = 0;
            this.setY(this.getY() - speedy - this.vy);
        }
        
        /*if ((this.getX() > 1374 && this.getX() < 1436) || 
            (this.getX() > 1952 && this.getX() < 2080) ||
            (this.getX() > 3318 && this.getX() < 3390)) {
                this.vy = -10;
                this.vx = 0;
                this.setY(this.getY() - speedy - this.vy);
        }
        */

        
        
        this.animation(deltaTime);
        this.collision();
    }

    @Override
    public void collision(){
        //verificar se colidiu pela direita
        if (this.getGame().getMario().getX() + this.getGame().getMario().getWidth() > this.getX() + 40 &&
            this.getGame().getMario().getX() + this.getGame().getMario().getWidth() < this.getX() + 82 &&
            this.getGame().getMario().getY() + this.getGame().getMario().getHeight() >= this.getY() &&
            this.getGame().getMario().getY() < this.getY() + this.getHeight()) 
        {
            if(!this.isMarked()){
            this.getGame().getMario().setState(4, 0);
            }
        }
        //verifica se colidiu pela esquerda
        if (this.getGame().getMario().getX() < this.getX() + this.getWidth() - 40 &&
            this.getGame().getMario().getX() > this.getX() + this.getWidth() - 82 &&
            this.getGame().getMario().getY() + this.getGame().getMario().getHeight() >= this.getY() &&
            this.getGame().getMario().getY() < this.getY() + this.getHeight())           
        {
            if(!this.isMarked()){
            this.getGame().getMario().setState(4, 0);
            }
        }
        // Verifica se colidiu por cima
        if (this.getGame().getMario().getX() + this.getGame().getMario().getWidth() > this.getX() + 40 &&
            this.getGame().getMario().getX() < this.getX() + this.getWidth() - 0 &&
            this.getGame().getMario().getY() + this.getGame().getMario().getHeight() + this.getGame().getMario().getSpeedy() >= this.getY() &&
            this.getGame().getMario().getY() + this.getGame().getMario().getHeight() + this.getGame().getMario().getSpeedy() < this.getY() + this.getHeight()) 
        {
            this.setMarked(true);
            this.setMarkedTime(System.currentTimeMillis());
            
        }
        
        if (this.isMarked()) {
        this.vx = 0;
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - getMarkedTime();

        if (elapsedTime >= 1000) {
            this.setVisible(false);
        }
        }   
    }

    public void animation(double deltaTime){
        super.animation(deltaTime);
    }

   @Override
   public void draw(Graphics g) {
    
    int startX, startY, endX, endY;

    if (!isMarked()) {
        startX = this.getFramex() * (160 + 50);
        startY = this.getFramey() * 160;
        endX = (this.getFramex() + 1) * (160 + 50) - 50;
        endY = (this.getFramey() + 1) * 160;
    } else {
        startX = 420; 
        startY = this.getFramey() * 160;
        endX = 581;
        endY = (this.getFramey() + 1) * 160;
    }
    if(this.getVisible()){
        g.drawImage(
            this.getImage(),
            this.getX(),
            this.getY(),
            this.getX() + this.getWidth(),
            this.getY() + this.getHeight(),
            startX, startY, endX, endY,
            null
        );    
    }
   }
   
   public int onGround(){
        int distance = 0;        
        for(Tile tile: this.getGame().tiles){
          if (
            this.getX() + this.getWidth() > tile.getX()+ 20 &&
            this.getX() < tile.getX()+tile.getWidth() - 20 &&
            this.getY() + this.getHeight() + this.vy >= tile.getY() +10 &&
            this.getY() + this.getHeight() + this.vy < tile.getY() + tile.getHeight()){
               distance = tile.getY();
            } 
        }
        
        return distance;
    }

}

