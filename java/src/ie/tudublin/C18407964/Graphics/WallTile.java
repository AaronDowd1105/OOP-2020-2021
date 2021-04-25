package ie.tudublin.C18407964.Graphics;

import ie.tudublin.C18407964.Screen;

public class WallTile extends Tile {
	
	public WallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}
    
    public boolean isSolid(){
        return true;
    }
	
}

