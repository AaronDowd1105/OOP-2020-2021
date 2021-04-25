package ie.tudublin.C18407964;

import ie.tudublin.C18407964.Graphics.Sprite;

public class Zombie {
    public int x, y;
    public Sprite sprite;
    public Player target;
    public int dir = 2;
    public Zombie(int x, int y, Player target){
        this.x = x;
        this.y = y;
        sprite = Sprite.zombie;
        this.target = target;
    }
    public void render(Screen screen){
        screen.renderZombie(x-16, y-16, sprite);
    }
    public void update(){
        move();
        getDistanceFromPlayer();
    }
    public void move(){
       int xa = 0;
       int ya = 0;
        if(x < target.x) xa++;
        if(x > target.x) xa--;
        if(y < target.y) ya++;
        if(y > target.y) ya--;
        if (xa > 0 ) dir = 1;
        if (xa < 0 ) dir = 3;
        if (ya > 0 ) dir = 2;
        if (ya < 0 ) dir = 0;
        if (dir == 0) sprite = Sprite.zombieBack;
        if (dir == 3) sprite = Sprite.zombieLeft;
        if (dir == 1) sprite = Sprite.zombieRight;
        if (dir == 2) sprite = Sprite.zombie;
 
        if(xa != 0 || ya != 0){
            x+= xa;
            y+= ya;
        }
    }
    public int getDistanceFromPlayer(){
       if(target.y - y == 0){
           return 0;
       } 
       int distance = (int)Math.sqrt((target.x - x)* (target.x - x)+(target.y - y)* (target.y - y));
        return distance;


    }
}
    