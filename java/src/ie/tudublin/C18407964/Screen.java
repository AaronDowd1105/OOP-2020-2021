package ie.tudublin.C18407964;

import ie.tudublin.C18407964.Graphics.Sprite;

public class Screen {
    public int width;
    public int height;
    public int[] pixels;
    public int xOffset, yOffset;

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void render(){
        for(int y =0; y < height; y++){
            
            for(int x =0; x < width; x++){
                
               if(x > 10 && y == 20){
                pixels[x + y * width] = 0x0000ff; 
               }
               else{
                pixels[x + y * width] = 0x000000;
               }
            }
        

        }

    }
    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0x000000;
        }
    }
    public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;	
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0; //stop breaking
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

    public void renderTile(int xp, int yp, Sprite sprite){
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++){
            int ya = y + yp;
            for (int x = 0; x <sprite.SIZE; x++){
                int xa = x + xp;
                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height ) break;
                if (xa < 0) xa = 0;
                
                pixels[xa + ya * width] = sprite.pixels[x + y * 16];
            }
        }
    }
    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
        
}
