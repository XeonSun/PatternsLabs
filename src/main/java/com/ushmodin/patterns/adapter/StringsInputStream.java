package com.ushmodin.patterns.adapter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringsInputStream implements StringsReadableStream{
    private InputStream inputStream;
    public StringsInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String[] read() throws IOException {
        var br = new BufferedReader(new InputStreamReader(inputStream));
        var str = new ArrayList<String>();
        while (br.ready())
            str.add(br.readLine());
        return str.toArray(String[]::new);
    }
}
