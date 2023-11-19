package Sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import superlinconbro.GameLoop;

public class Coins {
    private int x, y;
    private static final int xe = 20, ye = 50; // Coordenadas da moeda estática (irão ser alteradas)
    private Image[] images;
    private int currentFrame;
    private int totalFrames;
    private int delay;
    private long lastTimeChange;
    private static int counter;
    private Image coinImage;

    private static final int amplitude = 20; // Amplitude da animação
    private static final int period = 1000; // Período da animação em milissegundos

    public Coins(int x, int y) {
        this.x = x;
        this.y = y;
        currentFrame = 0;
        delay = 50;

        images = new Image[4];
        for (int i = 0; i < images.length; i++) {
            ImageIcon ii = new ImageIcon("src/Sprites/coin" + i + ".png");
            images[i] = ii.getImage();
        }
        totalFrames = images.length;
        lastTimeChange = System.currentTimeMillis();

        ImageIcon coinIcon = new ImageIcon("src/Sprites/coin4.png");
        coinImage = coinIcon.getImage();
    }

    private void animation() {
        long elapsedTime = System.currentTimeMillis() - lastTimeChange;

        int offsetY = (int) (amplitude * Math.sin(2 * Math.PI * elapsedTime / period));

        y += offsetY;
    }

    public void draw(Graphics g) {

        animation();

        g.drawImage(coinImage, xe, ye, null);

        g.drawImage(images[currentFrame], x, y, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("X" + counter, xe + 5, ye);

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

    public int getCounter() {
        return counter;
    }
}

