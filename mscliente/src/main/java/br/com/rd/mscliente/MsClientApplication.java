package br.com.rd.mscliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.rd"})
public class MsClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsClientApplication.class, args);
	}
}