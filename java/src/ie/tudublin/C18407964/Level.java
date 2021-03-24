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
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4; //+16 is to render 1 tile ahead
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4; //corner pins, space that is rendered
		System.out.println("anything"+ xScroll+ yScroll);
		
		for(int y = y0; y < y1; y++){
			for (int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
				
			}
		}
	}


    public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= width || y >= height ) return Tile.ground;
		if (tiles[x+y*width] == 0xffffd800) return Tile.ground;
		return Tile.ground;
	}

}
