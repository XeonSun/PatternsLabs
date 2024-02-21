package com.ushmodin.patterns.state;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum States implements State{
    IDLE("student/idle.png"),
    SLEEP("student/sleep.png"),
    HAPPY("student/happy.png"),
    PANIC("student/panic.png");

    private Image image;
    private States(String path){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            image = ImageIO.read(classloader.getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image getImage(){
        return image;
    }
}
