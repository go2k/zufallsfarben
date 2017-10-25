package com.sabel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Layout extends JFrame {
    JPanel jpNorth;
    JPanel jpWest;
    JPanel jpCenter;
    JPanel jpEast;
    JPanel jpSouth;
    Random random;

    public Layout() {
        this.setTitle("Layoutmanager");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.initComponents();
        this.initEvents();
        this.setVisible(true);
    }

    private void initComponents() {
        jpNorth = new JPanel();
        jpWest = new JPanel();
        jpCenter = new JPanel();
        jpEast = new JPanel();
        jpSouth = new JPanel();
        random = new Random(256);
        JLabel jlNorth = new JLabel("North");
        JLabel jlWest = new JLabel("West");
        JLabel jlCenter = new JLabel("Center");
        JLabel jlEast = new JLabel("East");
        JLabel jlSouth = new JLabel("South");

        jpNorth.add(jlNorth);
        jpNorth.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        jpWest.add(jlWest);
        jpWest.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        jpCenter.add(jlCenter);
        jpCenter.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        jpEast.add(jlEast);
        jpEast.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        jpSouth.add(jlSouth);
        jpSouth.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

        this.add(jpNorth, BorderLayout.NORTH);
        this.add(jpWest, BorderLayout.WEST);
        this.add(jpCenter, BorderLayout.CENTER);
        this.add(jpEast, BorderLayout.EAST);
        this.add(jpSouth, BorderLayout.SOUTH);
    }

    private void initEvents() {
        MeinMouseListener mml;
        mml = new MeinMouseListener();
        mml.setPanel(jpNorth);
        jpNorth.addMouseListener(mml);

        mml = new MeinMouseListener();
        mml.setPanel(jpSouth);
        jpSouth.addMouseListener(mml);

        mml = new MeinMouseListener();
        mml.setPanel(jpEast);
        jpEast.addMouseListener(mml);

        mml = new MeinMouseListener();
        mml.setPanel(jpWest);
        jpWest.addMouseListener(mml);

        mml = new MeinMouseListener();
        mml.setPanel(jpCenter);
        jpCenter.addMouseListener(mml);
    }

    // Innere Klasse
    public class MeinMouseListener extends MouseAdapter {
        JPanel jPanel;

        public void setPanel(JPanel jPanel) {
            this.jPanel = jPanel;
        }

        private void setzeFarbe() {
            jPanel.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setzeFarbe();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setzeFarbe();
        }
    }
}
