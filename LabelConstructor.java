package learn_java.simple_player;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelConstructor extends JLabel {
    LabelConstructor(String text, Font font, ImageIcon icon, Color foreground) {
        this.setText(text);
        this.setFont(font);
        this.setIcon(icon);
        this.setForeground(foreground);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
