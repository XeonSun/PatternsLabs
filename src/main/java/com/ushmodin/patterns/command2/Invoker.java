package com.ushmodin.patterns.command2;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke(){
        if(command != null) command.execute();
    }
}
