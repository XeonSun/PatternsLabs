package com.ushmodin.patterns.adapter;

import java.io.*;

public class Main {
    public static void main(String[] args){


        var s = new String[]{"Hello Java\n","String Stream","Adapter"};
        try(OutputStream os = new FileOutputStream("test.out")){
            StringsWritableStream stringsStream= new StringsOutputStream(os);
            stringsStream.write(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(var reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.out")))) {
            while (reader.ready())
                System.out.println(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
