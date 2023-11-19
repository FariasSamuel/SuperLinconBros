package Sprites;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

import superlinconbro.GameLoop;


class Layer {
	private GameLoop game;
	private int width;
	private int height;
	private double speedModifier;
	private Image image;
	private double x;
	private double y;
	
	public Layer (GameLoop game, int width, int height, double speedModifier, String imagePath, double xI, double yI) {
		this.game = game;
		this.width = width;
		this.height = height;
		this.speedModifier = speedModifier;
		this.image = new ImageIcon(imagePath).getImage();
        this.x = xI;
        this.y = yI;
	}
	
	public void update() {
		double gameSpeed = game.getSpeed();
		this.x -= this.speedModifier*gameSpeed;
	}
	
	 public void draw(Graphics context) {
	     context.drawImage(this.image, (int) this.x, (int) this.y, null);
	}
}


public class Background {
    private GameLoop game;
	private int width;
    private int height;
	private Image layer1Image, layer2Image, layer3Image, layer4Image, layer5Image;
	private Layer layer1, layer2, layer3, layer4, layer5;
	private List<Layer> backgroundLayers;

		public Background(GameLoop game, int width, int height, String layer1ImagePath, String layer2ImagePath,
		                      String layer3ImagePath, String layer4ImagePath, String layer5ImagePath) {
			 this.game = game;
		     this.width = width;
		     this.height = height;

		     this.layer1Image = new ImageIcon(layer1ImagePath).getImage();
		     this.layer2Image = new ImageIcon(layer2ImagePath).getImage();
		     this.layer3Image = new ImageIcon(layer3ImagePath).getImage();
		     this.layer4Image = new ImageIcon(layer4ImagePath).getImage();
		     this.layer5Image = new ImageIcon(layer5ImagePath).getImage();

		     this.layer1 = new Layer(layer1Image, 0.1);
		     this.layer2 = new Layer(layer2Image, 0.2);
		     this.layer3 = new Layer(layer3Image, 0.3);
		     this.layer4 = new Layer(layer4Image, 0.4);
		     this.layer5 = new Layer(layer5Image, 0.5);

		     this.backgroundLayers = new ArrayList<>();
		     this.backgroundLayers.add(layer5);
		     this.backgroundLayers.add(layer4);
		     this.backgroundLayers.add(layer3);
		     this.backgroundLayers.add(layer2);
		     this.backgroundLayers.add(layer1);
		    }

		 public void update() {
		     double gameSpeed = game.getSpeed();
		        for (Layer layer : backgroundLayers) {
		            layer.update(gameSpeed);
		        }
		    }
		 public void draw(Graphics context) {
		      for (Layer layer : backgroundLayers) {
		          layer.draw(context);
		        }
		    }
    
}
