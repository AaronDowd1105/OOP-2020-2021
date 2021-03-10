package ie.tudublin.C18407964.Graphics;

import com.jogamp.newt.Screen;

public class GroundTile extends Tile{
    public GroundTile(Sprite sprite){
        super(sprite);
    }
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }    
}
