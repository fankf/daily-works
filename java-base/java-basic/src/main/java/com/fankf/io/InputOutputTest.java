package com.fankf.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutputTest {
    public static void main(String[] args) throws IOException {
        String writePath = "";
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.contains("windows")) {
            writePath = "D:/ofd/";
        } else {
            writePath = "/home/ofd/";
        }
        File file = new File(writePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter writer = null;
        try {
            File file0 = new File(writePath + " 1.txt");
            if (!file0.exists()) {
                file0.createNewFile();
            }
            writer = new FileWriter(file0, false);
            writer.append("1234566");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
