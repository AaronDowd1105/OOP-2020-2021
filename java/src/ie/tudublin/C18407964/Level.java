package ie.tudublin.C18407964;

import ie.tudublin.C18407964.Graphics.Tile;

public class Level {
    protected int width , height;
    protected int[] tilesint;
    protected int[] tiles;
    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tilesint = new int[width * height];
    }
    public Level(String path){
		loadLevel(path);
		generateLevel();
	}
    protected void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}


    public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5; //+16 is to render 1 tile ahead
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5; //corner pins, space that is rendered
		
		for(int y = y0; y < y1; y++){
			for (int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
				
			}
		}
	}


    public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= width || y >= height ) return Tile.desert;
		if (tiles[x+y*width] == 0xffffd800) return Tile.ground;
		if (tiles[x+y*width] == 0xff000000) return Tile.wall;
		return Tile.ground;
	}

}
