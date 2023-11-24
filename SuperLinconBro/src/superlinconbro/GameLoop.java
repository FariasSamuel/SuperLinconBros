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
public class GameLoop extends JPanel{
    private int width;
    private int heigth;
    private Mario mario;
    //private ArrayList<Tile> floor;
    private ArrayList<Tile> tiles;
    
    
    public GameLoop() throws IOException {
       this.mario = new Mario();
       // this.floor = new ArrayList<>();
       this.tiles = new ArrayList<>();
       /* 
       * floor.add(new Tile(0, 500, 3376, 32, 0, 208, 3376,240));
       * floor.add(new Tile(0, 564, 3376, 32, 0, 208, 3376,240));
       * floor.add(new Tile(0, 628, 3376, 32, 0, 208, 3376,240));D
       */
       
       //interrogações
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
             
    }
    
    @Override
    public void paint(Graphics g){
        super.paintComponent(g); 
        g.setColor(Color.white);
        g.fillRect(0, 0, 1600, 1600);
        g.setColor(Color.black);
        mario.paint(g);
        
        // for (Tile tile : floor) {
        //    tile.draw(g);
        // }
        for (Tile tile : tiles) {
            tile.draw(g);
        }
    }
    
    public void gamelLogic(ArrayList<Integer>input){
        mario.move(input,0);
        
        // for (Tile tile : floor) {
        //    tile.update(0,0);
        // }
        for (Tile tile : tiles) {
            tile.update(0,0);
        }
    }
    
    public void restart(){

    }
}