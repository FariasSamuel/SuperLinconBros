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
        super.setX(x);
        super.setY(y);
        super.setWidth(width);
        super.setHeight(height);
        this.direction = direction;
        super.setGame(game);
        super.setRange(range);
    }

    @Override
    public void update() { }

    @Override
    public void update(int speed, int speedy, int time, int deltaTime) {
        //Gravidade
        vy += 5;
        super.setY(super.getY() + 5);

        //Fazer com que ele volte para o chao
        if(!super.isMarked()){
            if(super.getY()>super.getOriginY()){
                vy = 0;
                super.setY(getOriginY());
            }


        }
    }



}
