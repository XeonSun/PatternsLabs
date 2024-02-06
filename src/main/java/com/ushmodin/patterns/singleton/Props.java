package com.ushmodin.patterns.singleton;

import java.io.IOException;
import java.util.Properties;

public class Props {
    private static Props instance;
    private Properties data;
    private Props(){
        data = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try(var fis = classloader.getResourceAsStream("config.properties")){
            data.load(fis);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static Props getInstance(){
        if (instance == null) {
            instance = new Props();
        }
        return instance;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
