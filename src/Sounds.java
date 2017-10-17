/**
 * Created by student on 10/17/17.
 */
import java.io.*;
import sun.audio.*;
public class Sounds {
    private String n;
    public Sounds(String name){
        n=name;
    }
    public void makeSound() throws Exception{
        String in = "res/"+n;
        InputStream wav = new FileInputStream(in);
        AudioStream audioStream = new AudioStream(wav);
        AudioPlayer.player.start(audioStream);
    }
}
