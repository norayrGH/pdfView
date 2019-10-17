package com.pdfReader.pdfreader.controler;

import com.pdfReader.pdfreader.PDFInitialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class Controller {
    @Autowired
    PDFInitialization pdfInitialization;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF1() throws IOException {


        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "Amalya Muradayan Portfolio.pdf";
        headers.add("content-disposition", "inline;filename=" + filename);

            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdfInitialization.pdfToByte(), headers, HttpStatus.OK);
        return response;
    }
}
