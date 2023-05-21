package learn_java.simple_player;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonConstructor extends JButton{
    ButtonConstructor(int width, int height, String text, ImageIcon icon, Color color, Border border) {
        this.setPreferredSize(new Dimension(width, height));
        this.setText(text);
        this.setIcon(icon);
        this.setBackground(color);
        this.setBorder(border);
    }
}
