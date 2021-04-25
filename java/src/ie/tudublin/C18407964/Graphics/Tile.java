package ie.tudublin.C18407964.Graphics;

import ie.tudublin.C18407964.Screen;

public class Tile {
    public int x, y;
    public Sprite sprite;
    public static Tile ground = new GroundTile(Sprite.ground);
    public static Tile desert = new DesertTile(Sprite.desert);
    public static Tile wall = new WallTile(Sprite.wall);
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }
    public boolean isSolid(){
        return false;
    }
    public void render(int x, int y, Screen screen){
		
	}

}
