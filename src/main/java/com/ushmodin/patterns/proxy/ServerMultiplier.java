package com.ushmodin.patterns.proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerMultiplier implements Multipiler{
    @Override
    public double mult(double a, double b) {
        try(var socket = new Socket("localhost",10000)) {
            var input = new DataInputStream(socket.getInputStream());
            var output = new DataOutputStream(socket.getOutputStream());
            output.writeDouble(a);
            output.writeDouble(b);

            return input.readDouble();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
