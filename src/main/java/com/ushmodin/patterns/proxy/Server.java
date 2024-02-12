package com.ushmodin.patterns.proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try(var ss = new ServerSocket(10000);) {
        while (true) {
            try (var client = ss.accept();) {
                var input = new DataInputStream(client.getInputStream());
                var output = new DataOutputStream(client.getOutputStream());
                double a = input.readDouble();
                double b = input.readDouble();
                output.writeDouble(a * b);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}