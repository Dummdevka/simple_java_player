package learn_java.simple_player;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.LayoutManager;

public class PanelConstructor extends JPanel{
    // JPanel panel;
    PanelConstructor(int width, int height, Color color, Border border, LayoutManager layout) {
        // panel = new JPanel();
        // panel.setBounds(x, y, width, height);
        this.setBackground(color);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(layout);
    }
}
