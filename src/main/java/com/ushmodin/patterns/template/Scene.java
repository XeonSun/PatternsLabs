package com.ushmodin.patterns.template;

import com.ushmodin.patterns.template.factory.MovingBallFactory;
import com.ushmodin.patterns.template.factory.MovingBoxFactory;
import com.ushmodin.patterns.template.factory.MovingObjectFactory;
import com.ushmodin.patterns.template.factory.MovingStarFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scene {
    private JPanel panel1;
    private JButton boxButton;
    private JButton starButton;
    private JButton exitButton;
    private JButton ballButton;
    private JPanel objectsPanel;

    Dimension dimension = new Dimension(600, 600);

    private ActionListener getActionListener(MovingObjectFactory factory) {
        return e -> {
            MovingObject movingObject = factory.createInstance();
            objectsPanel.add(movingObject);
            Insets insets = objectsPanel.getInsets();
            movingObject.setBounds(insets.left, insets.top, dimension.width, dimension.height);
            new Thread(movingObject).start();
        };
    }

    public Scene() {
        ballButton.addActionListener(getActionListener(new MovingBallFactory(dimension)));
        boxButton.addActionListener(getActionListener(new MovingBoxFactory(dimension)));
        starButton.addActionListener(getActionListener(new MovingStarFactory(dimension)));
        exitButton.addActionListener(e -> System.exit(0));
    }


    public JPanel getPanel() {
        return panel1;
    }


    private void createUIComponents() {
        objectsPanel = new JPanel() {
            {
                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();
            }
        };
        objectsPanel.setPreferredSize(dimension);
        objectsPanel.setLayout(null);

    }
}
