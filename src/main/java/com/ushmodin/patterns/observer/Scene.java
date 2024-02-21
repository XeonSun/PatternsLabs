package com.ushmodin.patterns.observer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Scene {
    private JLabel leftEyeLabel;
    private JLabel rightEyeLabel;
    private JLabel noseLabel;
    private JLabel mouthLabel;

    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;

    private void createUIComponents() {
        //Разные варианты
        mouthLabel = new Mouth();
        ((Mouth) mouthLabel).attachObserver(new SimpleObserver());

        noseLabel = new Nose();
        ((Nose) noseLabel).attachObserver(new Observer() {
            @Override
            public void update(Subject subject) {
                ((Nose) noseLabel).updateState();
            }
        });

        leftEyeLabel = new Eye(){
            {
                this.attachObserver(Subject::updateState);}
        };

        rightEyeLabel = new Eye(){
            {
                this.attachObserver(Subject::updateState);}
        };

    }
}
