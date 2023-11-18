package Sprites;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Coins {
    private int x, y; 
    private Image[] images; 
    private int currentFrame; // Índice da imagem atual
    private int totalFrames; // Número total de frames na animação
    private int delay; // Atraso entre os frames
    private long lastTimeChange; // Tempo da última mudança de frame

    public Coins(int x, int y) {
        this.x = x;
        this.y = y;
        currentFrame = 0;
        delay = 50; 

        images = new Image[4]; 
        for (int i = 0; i < images.length; i++) {
            ImageIcon ii = new ImageIcon("" + i + ".");
            images[i] = ii.getImage();
        }
        totalFrames = images.length;
        lastTimeChange = System.currentTimeMillis();
    }

    public void draw(Graphics g) {
        g.drawImage(images[currentFrame], x, y, null);

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
}
