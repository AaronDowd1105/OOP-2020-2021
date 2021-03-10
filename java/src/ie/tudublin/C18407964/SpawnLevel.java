package ie.tudublin.C18407964;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path){
		try{
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int h = height = image.getHeight();
			int w = width = image.getWidth();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("EXCEPTION: couldnt load image file");
		}
	}
	
	public void generateLevel(){
			
		}
	}
