package ru.gb.dev.spring.pfs.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PfsServerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfsServerDiscoveryApplication.class, args);
	}

}
