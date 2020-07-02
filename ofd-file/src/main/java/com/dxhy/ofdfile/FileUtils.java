package com.dxhy.ofdfile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static final String windowsPath = "D:/ofd/";
    public static final String linuxPath = "/home/dxhy/ofd/";

    public static void main(String[] args) throws IOException {
        write("1","1233333333333");
        String read = read("1");
        System.out.println(read);
    }

    private static String path() {
        String path = "";
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.contains("windows")) {
            path = windowsPath;
        } else {
            path = linuxPath;
        }
        return path;
    }

    public static String read(String fileName) throws IOException {
        String readPath = path();
        File file0 = new File(readPath + fileName + ".ofd");
        FileReader reader = new FileReader(file0);
        char[] buf = new char[128];
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = reader.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));

        }
        return sb.toString();
    }

    public static void write(String fileName, String data) throws IOException {
        String writePath = path();
        File file = new File(writePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter writer = null;
        try {
            File file0 = new File(writePath + fileName + ".ofd");
            if (!file0.exists()) {
                file0.createNewFile();
            }
            writer = new FileWriter(file0, false);
            writer.append(data);
            writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
