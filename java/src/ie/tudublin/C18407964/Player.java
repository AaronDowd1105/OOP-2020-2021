package ie.tudublin.C18407964;

import ddf.minim.ugens.Abs;
import ie.tudublin.C18407964.Graphics.Sprite;

public class Player {
    private Keyboard input;
    public int x, y;
    public Sprite sprite;
    public int dir = 2;
    public Level level;

    public Player(Keyboard input, Level level) {
        this.input = input;
        this.sprite = Sprite.player;
        this.level = level;
    }
    public void update(){
        int xa = 0;
        int ya = 0;
        if(input.up) {
            ya--;
        }
        if(input.down) {
            ya++;
        }
        if(input.right) {
            xa++;
        }
        if(input.left) {
            xa--;
        }
        move(xa, ya);
    }
    public void move(int xa, int ya){
        if(xa!=0 && ya != 0){
			move(xa, 0);
			move(0, ya); //
			return;
		} 
		
		if (xa > 0) dir = 1; //east
		if (xa < 0) dir = 3; //west
		if (ya > 0) dir = 2; //south
		if (ya < 0) dir = 0; //north
		
		for(int x = 0; x < Math.abs(xa); x++){
			if(!collision(abs(xa), ya)) { //if not colliding move
				this.x += abs(xa) *2;
			}
			}
		for(int y = 0; y < Math.abs(ya); y++){
		if(!collision(xa, abs(ya))) { //if not colliding move
			this.y+= abs(ya) *2;
		}
		}


       
    }
    public void render(Screen screen){
        screen.renderPlayer(x-16, y-16, sprite);
    }

    private int abs(double value){
		if(value < 0) return -1;
		else return 1;
	}
    private boolean collision(int xa, int ya){
        boolean solid = false;
        for(int c = 0; c < 4; c++){// check each 4 corner
			int xt = ((x + xa) + c % 2 * 12 - 7)/32;
			int yt = ((y + ya) + c / 2 * 12 + 2)/32;
			if (level.getTile(xt, yt).isSolid()) solid = true;
		}
        System.out.println("solid" + solid);
        return solid;
    }

}
