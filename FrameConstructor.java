package learn_java.simple_player;

import java.awt.Color;

import javax.swing.JFrame;

public class FrameConstructor extends JFrame{
    FrameConstructor(int width, int height, Color background) {
        this.setSize(width, height);
        this.setBackground(background);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
