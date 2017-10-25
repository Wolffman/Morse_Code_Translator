/**
 * Created by student on 10/17/17.
 */
import java.io.*;
import sun.audio.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Sounds {
    private String n;
    private Clip clip;
    public Sounds(String name){
        n=name;
        try {
            File file = new File("res/"+n);
            if(file.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip=AudioSystem.getClip();
                clip.open();
            }
            else {
                throw new RuntimeException("Sound file notfound" +"res/"+n);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }



    }
    public void play(){
        clip.setFramePosition(0);
       // clip.open();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

    public void soundy(String n) throws Exception {
       Sounds ns= new Sounds(n);
        ns.makeSound();
    }
    public void makeSound() throws Exception{
        String in = "res/"+n;
        InputStream wav = new FileInputStream(in);
        AudioStream audioStream = new AudioStream(wav);
        AudioPlayer.player.start(audioStream);
    }

}
