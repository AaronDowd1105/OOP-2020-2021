package ie.tudublin.C18407964;

import ie.tudublin.C18407964.Graphics.Sprite;

public class Player {
    private Keyboard input;
    public int x, y;
    public Sprite sprite;
    public int dir = 2;

    public Player(Keyboard input) {
        this.input = input;
        this.sprite = Sprite.player;
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
        if (xa > 0 ) dir = 1;
        if (xa < 0 ) dir = 3;
        if (ya > 0 ) dir = 2;
        if (ya < 0 ) dir = 0;
        if (dir == 0) sprite = Sprite.playerBack;
        if (dir == 3) sprite = Sprite.playerLeft;
        if (dir == 1) sprite = Sprite.playerRight;
        if (dir == 2) sprite = Sprite.player;

        int newX = x + xa*2;
        if (newX < 0 || newX > 1000){
         
        }
        else{
            x = newX;
        }

        int newY = y + ya*2;
        if (newY < 0 || newY > 1000){
         
        }
        else{
            y = newY;
        }
    }
    public void render(Screen screen){
        screen.renderPlayer(x-16, y-16, sprite);
    }
}
