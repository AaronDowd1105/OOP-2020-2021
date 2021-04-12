package ie.tudublin.C18407964;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class AudioManager extends PApplet {
    AudioPlayer ap;
    AudioBuffer ab;
    Minim minim;
    Clip chaseMusic;
    public AudioManager(String path) {
        //minim = new Minim(this);
        //ap = minim.loadFile(path, width);
       // System.out.println(minim.loadFile(path, width));
       // ap.play();
       try{
            File sound = new File(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(sound);
		    chaseMusic = AudioSystem.getClip();
			chaseMusic.open(audio);
       }
       catch(Exception e){
           System.out.println("audio not found");
           System.out.println(e);
       }
    }

    public void playchaseMusic(){
        chaseMusic.setFramePosition(0);
        chaseMusic.start();
    }
    public void setVolume(int distance){
        FloatControl volume = (FloatControl) chaseMusic.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue((float)-distance);
        if(distance > 60){
            volume.setValue(-60f);  
        }
       else if(distance > 40){
            volume.setValue(-40f);  
        }
        else if(distance > 20){
            volume.setValue(-20f);  
        }
        else if(distance < 20){
            volume.setValue(-10f);  
        }
    }
}
