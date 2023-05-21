package learn_java.simple_player;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audio = new File("/Users/dummdevka/java/learn_java/simple_player/audio.wav");
        new UI(audio); 
    }
}
