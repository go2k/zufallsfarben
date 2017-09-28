package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Zufallsfarben extends JFrame {

    private Random random;

    public Zufallsfarben() {
        this.setTitle("Zufallsfarben");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.initComponents();
        this.initEvents();
        this.setVisible(true);
    }

    private void initComponents() {
         random = new Random();
    }

    private void initEvents() {
        MeinMouseListener mml = new MeinMouseListener();
        this.addMouseListener(mml);
    }

    private void aendereFarbe() {
        this.getContentPane().setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }


    // Innere Klasse
    public class MeinMouseListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            aendereFarbe();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            aendereFarbe();
        }
    }


}
