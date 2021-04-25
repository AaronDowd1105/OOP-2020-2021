package ie.tudublin.C18407964.Graphics;

import ie.tudublin.C18407964.Screen;

public class DesertTile extends Tile {
	
	public DesertTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}
	public boolean isSolid(){
        return true;
    }
}