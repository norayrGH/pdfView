package com.pdfReader.pdfreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PdfreaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfreaderApplication.class, args);
	}

	@Bean
	public PDFInitialization pdfInitialization (){
		return new PDFInitialization();
	}
}
