package com.ushmodin.patterns.state;

import javax.swing.*;
import java.awt.*;

public class Student extends JPanel {
    public void setState(State state) {
        this.state = state;
        this.repaint();
    }

    private State state = States.IDLE;

    public Student(){
        super();

    }

    public void exam(){
        setState(States.PANIC);
    }

    public void holiday(){
        setState(States.HAPPY);
    }

    public void sem(){
        setState(States.SLEEP);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(state.getImage(),0,0,this);
    }
}
