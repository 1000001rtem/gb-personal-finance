package ru.gb.dev.spring.pfs.notifying.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 2019-03-03
 */

@Getter
@Component
public class ServiceConfig {

    @Value("${signing.key}")
    private String jwtSigningKey="";

}
