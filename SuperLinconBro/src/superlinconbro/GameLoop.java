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
    
    public GameLoop(int width) throws IOException{
       this.mario = new Mario(this);
      this.width = width;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.black);
        mario.paint(g);
    }
    
    public void gamelLogic(ArrayList<Integer>input){
        mario.move(input,0);
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
