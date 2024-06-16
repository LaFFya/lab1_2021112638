package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Write {
    public static void printout(String txt, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8));
            writer.write(txt);
        } catch (IOException e) {
            System.err.println("文件写入异常" + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("文件未打开: " + e.getMessage());
            }
        }
    }
}
