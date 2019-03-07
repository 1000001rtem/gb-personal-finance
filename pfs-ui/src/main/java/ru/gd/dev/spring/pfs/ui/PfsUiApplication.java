package ru.gd.dev.spring.pfs.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class PfsUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfsUiApplication.class, args);
	}

}
