/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package superlinconbro;

import java.awt.Graphics; 
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Tile {
    private int x;
    private int y;
    private int width;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    private int height;
    private int xi;
    private int yi;
    private int xf;
    private int yf;     // coordenadas que representam o recorte da imagem associada 
    private BufferedImage image;

    public Tile(int x, int y, int width, int height, int xi, int yi, int xf, int yf) throws IOException {
        this.x = x;
        this.y = (y+16);
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.width = width;
        this.height = height;
        String path = new File("src/Sprites/blocostile.png").getAbsolutePath();
        image = ImageIO.read(new File(path));

    }
    
    public Tile(int x, int y, int width, int height, int xi, int yi, int xf, int yf, BufferedImage image) {
        this.x = x;
        this.y = (y+16);
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void update(int speedx, int speedy) {
        this.x += speedx;
        this.y += speedy;
    }
    
   
    public void draw(Graphics g) {  
        g.drawImage(
            this.image, // Imagem a ser desenhada
            this.x,     // Posição x onde o tile será desenhado
            this.y,     // Posição y onde o tile será desenhado
            this.x + this.width * 2,    // Posição x final do tile
            this.y + this.height * 2,   // Posição y final do tile
            this.xi,    // Coordenada x inicial do recorte na imagem
            this.yi,    // Coordenada y inicial do recorte na imagem
            this.xf,    // Coordenada x final do recorte na imagem
            this.yf,    // Coordenada y final do recorte na imagem
            null       // Observador de imagem (não utilizado neste caso)
        );
    }
}