package ie.tudublin.C18407964;

public class Player {
    private Keyboard input;
    public int x, y;

    public Player(Keyboard input) {
        this.input = input;
    
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
        x += xa;
        y += ya;
    }

}
