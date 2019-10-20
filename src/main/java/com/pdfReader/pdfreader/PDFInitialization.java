package com.pdfReader.pdfreader;

import com.pdfReader.pdfreader.controler.Controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFInitialization {

    private byte [] pdfToByte = null;

    public PDFInitialization(){

        InputStream fis = null;

            ClassLoader classLoader = getClass().getClassLoader();
            try {
                fis = classLoader.getResourceAsStream("AmalyaMuradyanPortfolio.pdf");
            }
           catch (Exception e)
           {
               System.out.println(e);
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
