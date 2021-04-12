package ie.tudublin.C18407964;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;



public class Project extends Canvas implements Runnable {

 

    private static final long serialVersionUID = 1L;

    public static int width = 400;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "MusicDungeon";

    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Screen screen;
    private boolean running = false;
    private Level level;
    private Player player;
    private Zombie zombie;
    private AudioManager audioManager;


    

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    

    public Project(){
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);
        frame = new JFrame();
        key = new Keyboard();
        screen = new Screen(width, height);
        addKeyListener(key);
        level = new SpawnLevel("/level.png");
        player = new Player(key);
        zombie = new Zombie(200, 200, player);
        audioManager = new AudioManager(".//OOP-2020-2021//java//RES//Jaws.wav");
        audioManager.playchaseMusic();
    }

    public synchronized void start(){
        running =true;
        thread = new Thread(this, "Display"); //this thread is attached to game
        thread.start(); //starting new thread "display"
        }

    public synchronized void stop(){ //stop thread
        running = false;
        try {
        thread.join();
    } catch (InterruptedException e){

        }

    }

    public void run(){
        //code that gets executed on game-start
        long lastTime = System.nanoTime(); //current time set to Lasttime
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; //conversion
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus(); //component, dont need to click before move
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;//time between variables
            lastTime= now;
            while(delta >=1){ //only happen 60 times a second
                update();
                updates++; //FPS updates
                delta--;
            }

            render();
            frames++; // FPS
            if (System.currentTimeMillis() - timer > 1000){ //
                timer+= 1000;
                frame.setTitle(title + " | " + updates + "ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }

        }

        stop();

    }

    public void update(){
        key.update();
        player.update();
        zombie.update();
        if(zombie.getDistanceFromPlayer() < 80){
            audioManager.setVolume(zombie.getDistanceFromPlayer());
        }
        if(key.up){
       }
       if(key.down){
       }
       if(key.left){
       }
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){ //create buffer strat. if doesnt exist (null)
            createBufferStrategy(3);
            return; //exit method
        }

        screen.clear();
        int xOffset = player.x - screen.width/2;
        int yOffset = player.y - screen.height/2;
        Graphics graphics = bs.getDrawGraphics();
        level.render(xOffset, yOffset, screen);
        player.render(screen);
        zombie.render(screen);
        for(int i = 0; i < pixels.length; i++){
           pixels[i] = screen.pixels[i];
       }
        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        graphics.dispose();
        bs.show();
    }

    public static void main(String[] args){
        Project game = new Project(); //creates object of game
        game.frame.setResizable(false);
        game.frame.setTitle(Project.title);
        game.frame.add(game);//adds component (game) to frame
        game.frame.pack(); //size frame to size of component (height width)
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //End on 'x' button
        game.frame.setLocationRelativeTo(null); //centers window
        game.frame.setVisible(true);
        game.start();
        }

}
