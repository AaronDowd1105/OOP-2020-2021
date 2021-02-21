package ie.tudublin.C18407964;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    private boolean[] keys = new boolean[100];
    public boolean up, down, left, right;
    
    public void update(){
        up = keys[KeyEvent.VK_UP];
    }
    public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;	
	}
	public void keyTyped(KeyEvent e) {
		
	}

}
