package ie.tudublin.C18407964.Graphics;

import com.jogamp.newt.Screen;

import org.graalvm.compiler.nodes.gc.G1ArrayRangePreWriteBarrier;

public class Tile {
    public int x, y;
    public Sprite sprite;
    public static Tile ground = new GroundTile(Sprite.ground);
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }
    public boolean isSolid(){
        return false;
    }
    public void render(int x, int y, Screen screen){
		
	}

}
