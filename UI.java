package learn_java.simple_player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class UI implements ActionListener{
    ButtonConstructor playBtn;
    ButtonConstructor pauseBtn;
    ButtonConstructor resetBtn;

    Audio player;

    UI(File track) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        player = new Audio(track);
        Color wine = new Color(109, 59, 71);
        Color violet = new Color(69, 58, 73);
        Color cadet = new Color(40, 47, 68);
        Color oxford = new Color(25, 29, 50);

        Font basicFont = new Font("Gill Sans", Font.PLAIN, 20);

        //Panels
        PanelConstructor navbar = new PanelConstructor(500, 80, wine, null, new BorderLayout());
        PanelConstructor content = new PanelConstructor(500, 390, cadet, null, new BorderLayout());
        PanelConstructor buttonsContainer = new PanelConstructor(150, 80, violet, BorderFactory.createMatteBorder(2, 2, 2, 2, wine), new FlowLayout(FlowLayout.CENTER, 5, 15));
        PanelConstructor progressBar = new PanelConstructor(400, 50, oxford, null, new BorderLayout());
        PanelConstructor footer = new PanelConstructor(500, 30, Color.black, null, new BorderLayout());

        content.setBorder(new EmptyBorder(100, 30, 60, 30));
        // buttonsContainer.setBorder(new EmptyBorder(10, 50, 10, 50));

        content.add(buttonsContainer, BorderLayout.SOUTH);
        content.add(progressBar, BorderLayout.NORTH);

        //Labels
        //#TODO
        ImageIcon logoIcon = new ImageIcon("/Users/dummdevka/java/learn_java/simple_player/icons/icon.png");
        ImageIcon playIcon = new ImageIcon("/Users/dummdevka/java/learn_java/simple_player/icons/play.png");
        playIcon = new ImageIcon(playIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        

        LabelConstructor logo = new LabelConstructor("Wanna play?", basicFont, logoIcon, Color.lightGray);
        LabelConstructor progress = new LabelConstructor("Here will be a progress bar", basicFont, playIcon, Color.lightGray);
        // logo.setHorizontalAlignment(JLabel.CENTER);
        // progress.setHorizontalAlignment(JLabel.CENTER);

        navbar.add(logo, BorderLayout.CENTER);
        progressBar.add(progress, BorderLayout.CENTER);

        //Buttons
        ImageIcon pauseIcon = new ImageIcon("/Users/dummdevka/java/learn_java/simple_player/icons/pause.png");
        ImageIcon resetIcon = new ImageIcon("/Users/dummdevka/java/learn_java/simple_player/icons/reset.png");

        pauseIcon = new ImageIcon(pauseIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        resetIcon = new ImageIcon(resetIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        playBtn = new ButtonConstructor(150, 50, null, playIcon, Color.lightGray, BorderFactory.createBevelBorder(0));
        pauseBtn = new ButtonConstructor(50, 50, null, pauseIcon, Color.lightGray, BorderFactory.createBevelBorder(0));
        resetBtn = new ButtonConstructor(50, 50, null, resetIcon, Color.lightGray, BorderFactory.createBevelBorder(0));
        playBtn.addActionListener(this);
        pauseBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        buttonsContainer.add(pauseBtn);
        buttonsContainer.add(playBtn);
        buttonsContainer.add(resetBtn);
        //Frame
        FrameConstructor frame = new FrameConstructor(500, 500, Color.lightGray);

        frame.add(navbar, BorderLayout.NORTH);
        frame.add(content, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playBtn) {
            System.out.println("play");
            player.play();
        }
        else if(e.getSource() == pauseBtn) {
            player.pause();
        }
        else if(e.getSource() == resetBtn) {
            player.reset();
        }
    }

    protected void setFrameClose(FrameConstructor frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                player.close();
                System.exit(0);
            }
        });
    }
}
