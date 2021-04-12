package ie.tudublin.C18407964.Graphics;

public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite ground = new Sprite(32, 0, 0, SpriteSheet.tiles);
    public static Sprite player = new Sprite(32, 0, 0, SpriteSheet.player);
    public static Sprite playerBack = new Sprite(32, 1, 0, SpriteSheet.player);
    public static Sprite playerRight = new Sprite(32, 2, 0, SpriteSheet.player);
    public static Sprite playerLeft = new Sprite(32, 3, 0, SpriteSheet.player);
    public static Sprite zombie = new Sprite(32, 0, 0, SpriteSheet.zombie);
    public static Sprite zombieBack = new Sprite(32, 1, 0, SpriteSheet.zombie);
    public static Sprite zombieRight = new Sprite(32, 2, 0, SpriteSheet.zombie);
    public static Sprite zombieLeft = new Sprite(32, 3, 0, SpriteSheet.zombie);
    public Sprite(int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet =  sheet;
        load();
    }
    private void load(){
		for(int y=0; y < SIZE; y++){
			for (int x=0; x<SIZE; x++){
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y)*sheet.SIZE];
			}
		}
	}

}
