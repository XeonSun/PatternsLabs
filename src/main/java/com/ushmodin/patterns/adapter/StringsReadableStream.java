package com.ushmodin.patterns.adapter;

import java.io.IOException;

public interface StringsReadableStream {
    public String[] read() throws IOException;
}
