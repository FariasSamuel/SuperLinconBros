package Sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Coins {
    private int x, y;
    private static final int xe = 20, ye = 50; // Coordenadas da moeda estática (irão ser alteradas)
    private Image[] images;
    private int currentFrame; // Índice da imagem atual
    private int totalFrames; // Número total de frames na animação
    private int delay; // Atraso entre os frames
    private long lastTimeChange; // Tempo da última mudança de frame
    private static int counter;
    private Image coinImage;

    private static final int AMPLITUDE = 20; // Amplitude da animação
    private static final int PERIOD = 1000; // Período da animação em milissegundos

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

    private void animation() {
        long elapsedTime = System.currentTimeMillis() - lastTimeChange;

        // Calcula a posição vertical baseada no tempo
        int offsetY = (int) (AMPLITUDE * Math.sin(2 * Math.PI * elapsedTime / PERIOD));

        // Atualiza a posição Y da moeda animada
        y += offsetY;
    }

    public void draw(Graphics g) {
        // Chama o método de animação
        animation();

        // Desenha a moeda estática ao lado do contador
        g.drawImage(coinImage, xe, ye, null);

        // Desenha a moeda animada
        g.drawImage(images[currentFrame], x, y, null);

        // Desenha o contador na tela
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

    public int getContador() {
        return counter;
    }
}

