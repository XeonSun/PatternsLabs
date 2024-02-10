package com.ushmodin.patterns.adapter;

import java.io.IOException;
import java.io.OutputStream;

public class StringsOutputStream implements StringsWritableStream {
    private OutputStream outputStream;
    public StringsOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String[] strings) throws IOException {
        for (String s : strings) {
                outputStream.write(s.getBytes());
        }
    }
}
