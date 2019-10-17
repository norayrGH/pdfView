package com.pdfReader.pdfreader;

import com.pdfReader.pdfreader.controler.Controller;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFInitialization {

    private byte [] pdfToByte = null;

    public PDFInitialization(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new ClassPathResource("Amalya Muradayan Portfolio.pdf").getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pdfToByte = bos.toByteArray();

    }

    public byte[] pdfToByte(){
        return this.pdfToByte;
    }
}
