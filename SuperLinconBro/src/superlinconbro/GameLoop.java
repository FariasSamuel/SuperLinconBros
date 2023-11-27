/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superlinconbro;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.imageio.ImageIO; 

/**
 *
 * @author Samuel
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class GameLoop extends  JPanel{
    public int width;
    private int heigth;
    private Mario mario;
    private ArrayList<Tile> tiles;
    
    private int CameraX;
    private int CameraY;
    private Coins coin;
    private StaticCoins staticCoin;
    public GameLoop(int width) throws IOException{
       
       this.tiles = new ArrayList<Tile>();
      this.width = width;
      tiles.add(new Tile(256, 340,16 , 16, 384, 0, 400, 16));
       tiles.add(new Tile(352, 340,16 , 16, 384, 0, 400, 16));
       tiles.add(new Tile(416, 340,16 , 16, 384, 0, 400, 16));
       tiles.add(new Tile(480, 340,16 , 16, 384, 0, 400, 16));
       tiles.add(new Tile(416, 244,16 , 16, 384, 0, 400, 16));
       
       //tijolos
       tiles.add(new Tile(384, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(448, 340,16 , 16, 32, 0, 48, 16));
       
       //moitas
       tiles.add(new Tile(193, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(240, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(736, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(0, 404,48, 32, 320, 128, 368, 160));
       tiles.add(new Tile(1098, 404,48, 32, 320, 128, 368, 160));
       
       //canos
       tiles.add(new Tile(576, 404,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(860, 372,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(1180, 340,32, 32, 0, 128, 32, 160));
       
       //partedebaixodeumcano
       tiles.add(new Tile(860, 436,32, 16, 0, 144, 32, 160));
       tiles.add(new Tile(1180, 404,32, 16, 0, 144, 32, 160));
       tiles.add(new Tile(1180, 436,32, 16, 0, 144, 32, 160));
       
       //nuvens
       tiles.add(new Tile(96, 128,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(640, 128,32, 32, 0, 320, 48, 352));
       
       this.mario = new Mario(this);
       
       this.coin = new Coins(70,70);
       
       this.staticCoin = new StaticCoins(300, 300);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(93,148,251));
        g.fillRect(0, 0, 960, 480);
        g.setColor(Color.black);
        mario.paint(g);
        for (Tile tile : tiles) {
            tile.draw(g);
        }
        coin.draw(g);
        staticCoin.draw(g);
    }
    
    public void gamelLogic(ArrayList<Integer>input){
        mario.move(input,0);
        coin.update();
        for (Tile tile : tiles) {
            tile.update(CameraX,CameraY);
        }
        System.out.println(CameraX);
    }
    
    public void restart(){

    }
    public int getCameraX() {
        return CameraX;
    }

    public void setCameraX(int CameraX) {
        this.CameraX = CameraX;
    }

    public int getCameraY() {
        return CameraY;
    }

    public void setCameraY(int CameraY) {
        this.CameraY = CameraY;
    }
}
