package com.pdfReader.pdfreader.controler;

import com.pdfReader.pdfreader.PDFInitialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.io.*;

@RestController
public class Controller {
    @Autowired
    PDFInitialization pdfInitialization;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF1() throws IOException {


        HttpHeaders headers = new HttpHeaders();


        Client client = ClientBuilder.newClient();
        Response responseHEROKU = client.target("https://webtopdf.expeditedaddons.com/?api_key=TBC8540PSL9FGN6Z4K1QJXMIDH3U210653877VAEOWRY92&content=http://www.wikipedia.org&margin=10&html_width=1024&title=My PDF Title")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        System.out.println("status: " + responseHEROKU.getStatus());
        System.out.println("headers: " + responseHEROKU.getHeaders());
        System.out.println("body:" + responseHEROKU.readEntity(String.class));
        headers.setContentType(org.springframework.http.MediaType.parseMediaType("application/pdf"));
        String filename = "AmalyaMuradayanPortfolio.pdf";
        headers.add("content-disposition", "inline;filename=" + filename);

            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdfInitialization.pdfToByte(), headers, HttpStatus.OK);
        return response;
    }
}
