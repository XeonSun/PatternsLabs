package com.ushmodin.patterns.adapter;

import java.io.IOException;

public interface StringsWritableStream {
    void  write(String[] strings) throws IOException;
}
