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
import java.awt.image.BufferedImage;
import java.io.File;


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
    private BufferedImage imagemAlternativa;
    private BufferedImage imagemTiles;
    private ArrayList<Enemies> enemies = new ArrayList<>();
    private int CameraX;
    private int CameraY;
    private Coins coin;
    private StaticCoins staticCoin;
    private MysteryBox mysteryBox;
    public GameLoop(int width) throws IOException{
       
    this.tiles = new ArrayList<Tile>();
    this.width = width;
       
    BufferedImage imagemAlternativa = ImageIO.read(new File("src/Sprites/mapamario.png"));
      
      //interrogações
      tiles.add(new Tile(256, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(352, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(416, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(480, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(416, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(1696, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2208, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2240, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2464, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2560, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2656, 340,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(2560, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(3072, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(3104, 244,16 , 16, 384, 0, 400, 16));
      tiles.add(new Tile(4288, 340,16 , 16, 384, 0, 400, 16));
       
       //tijolos
       tiles.add(new Tile(384, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(448, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(1664, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(1728, 340,16 , 16, 32, 0, 48, 16));
       
       for (int m=1760; m<=2016; m+=32){
           for (int n=1; n<=8; n++){
               tiles.add(new Tile(m, 244,16 , 16, 32, 0, 48, 16));
           }
       }
       
       for (int m=2112; m<=2208; m+=32){
           for (int n=1; n<=3; n++){
               tiles.add(new Tile(m, 244,16 , 16, 32, 0, 48, 16));
           }
       }
       
       tiles.add(new Tile(2272, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(2816, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(2880, 244,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(2912, 244,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(2944, 244,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(3040, 244,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(3136, 244,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(3072, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(3104, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(4224, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(4256, 340,16 , 16, 32, 0, 48, 16));
       tiles.add(new Tile(4320, 340,16 , 16, 32, 0, 48, 16));
       
       //moitas
       tiles.add(new Tile(193, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(240, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(736, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(1504, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(1536, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(2112, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(2496, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(2544, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(4192, 436,48, 16, 176, 144, 224, 160));
       tiles.add(new Tile(0, 372,80, 48, 0, 160, 80, 208, imagemAlternativa));
       tiles.add(new Tile(1212, 372,80, 48, 0, 160, 80, 208, imagemAlternativa));
       tiles.add(new Tile(2336, 372,80, 48, 0, 160, 80, 208, imagemAlternativa));
       tiles.add(new Tile(3520, 372,80, 48, 0, 160, 80, 208, imagemAlternativa));
       tiles.add(new Tile(4960, 372,80, 48, 0, 160, 80, 208, imagemAlternativa));
       
       //canos
       tiles.add(new Tile(576, 404,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(860, 372,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(1180, 340,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(4096, 404,32, 32, 0, 128, 32, 160));
       tiles.add(new Tile(4544, 404,32, 32, 0, 128, 32, 160));
       
       //partedebaixodeumcano
       tiles.add(new Tile(860, 436,32, 16, 0, 144, 32, 160));
       tiles.add(new Tile(1180, 404,32, 16, 0, 144, 32, 160));
       tiles.add(new Tile(1180, 436,32, 16, 0, 144, 32, 160));
       
       //nuvens
       tiles.add(new Tile(96, 128,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(384, 64,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(576,128,80, 32, 432, 48, 512, 80, imagemAlternativa));
       tiles.add(new Tile(796,64,64, 32, 576, 32, 640, 64, imagemAlternativa));
       tiles.add(new Tile(1372, 64,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(1500,128,80, 32, 432, 48, 512, 80, imagemAlternativa));
       tiles.add(new Tile(1788,64,64, 32, 576, 32, 640, 64, imagemAlternativa));
       tiles.add(new Tile(2460, 96,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(2812, 64,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(3068,96,80, 32, 432, 48, 512, 80, imagemAlternativa));
       tiles.add(new Tile(3356,64,64, 32, 576, 32, 640, 64, imagemAlternativa));
       tiles.add(new Tile(3996, 64,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(4348, 32,32, 32, 0, 320, 48, 352));
       tiles.add(new Tile(4604,64,80, 32, 432, 48, 512, 80, imagemAlternativa));
       tiles.add(new Tile(4988, 96,32, 32, 0, 320, 48, 352));
       
       //escadinhas
       int p = 3200;
       int q = 436;
       for (int i=1; i<=4; i++){
           for (int j=4; j>=i; j--){
            tiles.add(new Tile(p, q,16, 16, 0, 16, 16, 32));
            p+= 32;
            }
        p= 3200 + (32*i);
        q-=32;
       }
       
       p = 3392;
       q = 436;
       for (int i=4; i>=0; i--){
           for (int j=1; j<=i; j++){
            tiles.add(new Tile(p, q,16, 16, 0, 16, 16, 32));
            p+= 32;
            }
        p= 3392;
        q-=32;
       }
       
       p = 3648;
       q = 436;
       for (int i=1; i<=4; i++){
           for (int j=5; j>=i; j--){
            tiles.add(new Tile(p, q,16, 16, 0, 16, 16, 32));
            p+= 32;
            }
        p= 3648 + (32*i);
        q-=32;
       }     
       
       p = 3872;
       q = 436;
       for (int i=4; i>=0; i--){
           for (int j=1; j<=i; j++){
            tiles.add(new Tile(p, q,16, 16, 0, 16, 16, 32));
            p+= 32;
            }
        p= 3872;
        q-=32;
       } 
       
       p = 4608;
       q = 436;
       for (int i=1; i<=8; i++){
           for (int j=9; j>=i; j--){
            tiles.add(new Tile(p, q,16, 16, 0, 16, 16, 32));
            p+= 32;
            }
        p= 4608 + (32*i);
        q-=32;
       }    
      
       //chão
       int i;
       int j; 
       for (j=468; j<=660; j+=32){
            for (i=0; i<=1372; i+=32){   
              tiles.add(new Tile(i, j,16, 16, 0, 0, 16, 16));
            }
        } 
       for (j=468; j<=660; j+=32){
            for (i=1436; i<=1952; i+=32){   
              tiles.add(new Tile(i, j,16, 16, 0, 0, 16, 16));
            }
       }
       
       for (j=468; j<=660; j+=32){
            for (i=2080; i<=3320; i+=32){   
              tiles.add(new Tile(i, j,16, 16, 0, 0, 16, 16));
            }
       }
       
       BufferedImage imagemTiles = ImageIO.read(new File("src/Sprites/blocostile.png"));
       for (j=468; j<=660; j+=32){
            for (i=3384; i<=5600; i+=32){   
              tiles.add(new Tile(i, j,16, 16, 0, 0, 16, 16, imagemTiles));
            }
       }
       
       //castelo
       tiles.add(new Tile(5280, 308,80, 80, 3232,128, 3312, 208, imagemAlternativa));  
       
       //Bandeira
       tiles.add(new Tile(5120, 116,32, 176, 3152,32,3184, 208, imagemAlternativa));
       
       this.mario = new Mario(this);
       
       this.coin = new Coins(150,100);
       
       this.staticCoin = new StaticCoins(300, 356, this);
       
       this.mysteryBox = new MysteryBox(254, 356);
       
       enemies.add(new Goomba(1350, 445, 40, 40, 1, this, 0.5));
       enemies.add(new Goomba(700, 445, 40, 40, 1, this, 0.5));
       enemies.add(new Goomba(417+1280, 445, 40, 40, 1, this, 0.5));
       enemies.add(new Koopa(800, 445, 40, 40, this));
       enemies.add(new Koopa(600, 445, 40, 40, this));


    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(93,148,251));
        g.fillRect(0, 0, 4000, 2000);
        g.setColor(Color.black);
        for (Tile tile : tiles) {
            tile.draw(g);
        }
        mario.paint(g);
        coin.draw(g);
        staticCoin.draw(g);
        mysteryBox.draw(g);
        for(Enemies enemy: enemies){
            if(!enemy.isMarked()){
               enemy.draw(g);
            }
        }
        
    }
    
    public void gamelLogic(ArrayList<Integer>input){
        coin.update();
        staticCoin.update();
        mysteryBox.update(mario, staticCoin);
        for (Tile tile : tiles) {
            tile.update(CameraX,CameraY);
        }
        mario.move(input,0);
        System.out.println(CameraX);
        
        for(Enemies enemie: enemies){
            enemie.update(2,0,10,60);
        }
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
    
    public Mario getMario(){
        return this.mario;
    }
}
