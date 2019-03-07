package ru.gb.dev.spring.pfs.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;
import ru.gb.dev.spring.pfs.accounting.util.UserContextInterceptor;

import java.util.List;

/**
 * http://localhost:10151/api/accounts
 *
 */

@EnableJpaAuditing
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class PfsAccountingApplication {

    @Primary
    @Bean
    public RestTemplate getCustomRestTemplate() {
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        interceptors.add(new UserContextInterceptor());
        template.setInterceptors(interceptors);
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(PfsAccountingApplication.class, args);
    }

}
