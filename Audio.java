package learn_java.simple_player;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
    Clip audio;

    Audio(File track) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream stream = AudioSystem.getAudioInputStream(track);
        audio = AudioSystem.getClip();
        audio.open(stream);
    }

    public void play() {
        audio.start();
    }

    public void pause() {
        audio.stop();
    }

    public void reset() {
        audio.setFramePosition(0);
    }

    public void close() {
        audio.close();
    }
    
}
