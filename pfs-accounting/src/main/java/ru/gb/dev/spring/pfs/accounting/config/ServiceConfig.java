package ru.gb.dev.spring.pfs.accounting.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author V. Zinchenko
 */

@Getter
@Component
public class ServiceConfig {
    @Value("${signing.key}")
    private String jwtSigningKey="";

}
