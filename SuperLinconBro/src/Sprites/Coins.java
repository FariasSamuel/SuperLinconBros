package Sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Coins {
    private int x, y;
    private static final int xe = 20, ye = 50; //coordenadas da moeda estática(irão ser alterados)
    private Image[] images; 
    private int currentFrame; // Índice da imagem atual
    private int totalFrames; // Número total de frames na animação
    private int delay; // Atraso entre os frames
    private long lastTimeChange; // Tempo da última mudança de frame
    private int counter; 
    private Image coinImage; 

    public Coins(int x, int y) {
        this.x = x;
        this.y = y;
        currentFrame = 0;
        delay = 50; 

        images = new Image[4]; 
        for (int i = 0; i < images.length; i++) {
            ImageIcon ii = new ImageIcon("caminho/para/imagem/" + i + ".png"); 
            images[i] = ii.getImage();
        }
        totalFrames = images.length;
        lastTimeChange = System.currentTimeMillis();

        ImageIcon coinIcon = new ImageIcon("caminho/para/imagem/moeda_estatica.png"); 
        coinImage = coinIcon.getImage();
    }

    public void draw(Graphics g) {
      
        g.drawImage(coinImage, xe, ye , null);

        g.drawImage(images[currentFrame], x, y, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Moedas: " + counter, xe + 30, ye); 

        // Atualiza o frame da animação se necessário
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTimeChange > delay) {
            lastTimeChange = currentTime;
            currentFrame = (currentFrame + 1) % totalFrames;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getContador() {
        return counter;
    }
}

