package com.yantong.filesys.client.handler;

import java.io.*;

public class FileReadHandler extends Thread {
    private final InputStream inputStream;
    private String fileTempPath;
    private DataInputStream dis;
    private DataOutputStream dos;
    private FileOutputStream fileOutputStream;

    public FileReadHandler(InputStream inputStream, String fileTempPath) throws FileNotFoundException {
        this.inputStream = inputStream;
        this.fileTempPath = fileTempPath;
        this.dis = new DataInputStream(inputStream);
//        this.dos = new DataOutputStream(new FileOutputStream(fileTempPath));
//        this.fileOutputStream = new FileOutputStream(fileTempPath);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
//                DataInputStream dis = new DataInputStream(inputStream);
//                dos = new DataOutputStream(fileOutputStream);
                byte[] buf = new byte[1024 * 9];
                int len = 0;
                if ((len = dis.read(buf)) != -1) {
                    dos = new DataOutputStream(new FileOutputStream(fileTempPath));
                    dos.write(buf, 0, len);
                }
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
//                continue;
            }
        }
    }
}
