package com.company.logs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogsFiles {

    private List filelogs;
    private File file;


    public LogsFiles() {
    }

    public void setFile(String str, String name) {

        file = new File("History_" + name + "_logs.txt");

        try {
            FileOutputStream bos = new FileOutputStream(file, true);
            bos.write (str.getBytes());
            bos.write("\n".getBytes());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile(File file){
        filelogs = new ArrayList();



    }

}
