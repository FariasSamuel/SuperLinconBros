package Sprites;

public class Goomba extends Enemies{

    private int previousState;

    //private followingState
    private int vy;
    private int vx;
    private int weight;
    private int originX;
    private int direction;

    public Goomba(int x, int y, int width, int height, int direction, Game game, int range) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.direction = direction;
        this.setGame(game);
        this.setRange(range);
    }

    @Override
    public void update() { }

    @Override
    public void update(int speed, int speedy, int time, int deltaTime) {
        //Gravidade
        //vy += 5;
       // this.setY(this.getY() + 5);

        //Fazer com que ele volte para o chao
        if(!this.isMarked()){
            if(this.getY()>this.getOriginY()){
                vy = 0;
                this.setY(getOriginY());
            }


        }
    }



}
