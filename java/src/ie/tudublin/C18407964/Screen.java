package ie.tudublin.C18407964;

import ie.tudublin.C18407964.Graphics.Sprite;
import ie.tudublin.C18407964.Graphics.Tile;

public class Screen {
    public int width;
	public int height;
    public int[] pixels;
    private int[] tiles = new int[16 * 16];
   
    
    private int xOffset, yOffset;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0x000000;
        }
    }

    public int[] getPixels(){
        return pixels;
    }
    

    public void renderPlayer(int xp, int yp, Sprite sprite) {
    	xp -= xOffset;
    	yp -= yOffset;
    	
    	for(int y = 0; y < 32; y++) {
    		int ya = y + yp;
    		for(int x = 0; x < 32; x++) {
    			int xa = x + xp;
    			if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
    			if (xa < 0) xa = 0;
    			int col = sprite.pixels[x + y * 32];
    			if(col != 0xff00ff00) pixels[xa + ya * width] = col;
    		}
    	}
    }

	public void renderZombie(int xp, int yp, Sprite sprite) {
    	xp -= xOffset;
    	yp -= yOffset;
    	
    	for(int y = 0; y < 32; y++) {
    		int ya = y + yp;
    		for(int x = 0; x < 32; x++) {
    			int xa = x + xp;
    			if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
    			if (xa < 0) xa = 0;
    			int col = sprite.pixels[x + y * 32];
    			if(col != 0xff00ff00) pixels[xa + ya * width] = col;
    		}
    	}
    }
    
    public void renderTile(int xp, int yp, Tile tile) {
    	xp -= xOffset;
    	yp -= yOffset;
    	for(int y = 0; y < tile.sprite.SIZE; y++) {
    		int ya = yp + y;
        	for(int x = 0; x < tile.sprite.SIZE; x++) {
        		int xa = xp + x;
        		if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
        		if(xa < 0) xa = 0;
        		pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
        	}
    	}
    }
   
    public void setOffset(int xOffset, int yOffset) {
    	this.xOffset = xOffset;
    	this.yOffset = yOffset;
    }


}