package ru.gb.dev.spring.pfs.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * http://localhost:10151/api/account/ping
 * http://localhost:10151/api/accounts/ping
 * http://localhost:10151/api/account
 * http://localhost:10151/api/accounts
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PfsAccountingApplication {

	public static void main(final String[] args) {
		SpringApplication.run(PfsAccountingApplication.class, args);
	}

}
