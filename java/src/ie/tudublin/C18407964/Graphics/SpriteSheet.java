package ie.tudublin.C18407964.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("spritesheet.png", 256);
    public SpriteSheet(String path, int size){
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }
    public void load(){
        try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight(); //getting h & w of pathed image
			image.getRGB(0, 0, w, h, pixels, 0, w); // translates image into pixels int
		} catch (IOException e) {
			e.printStackTrace();
		}
 
    }
    
}
