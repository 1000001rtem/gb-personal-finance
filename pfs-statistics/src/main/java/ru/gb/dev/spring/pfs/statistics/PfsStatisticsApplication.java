package ru.gb.dev.spring.pfs.statistics;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

/**
 * http://localhost:10152/api/categories
 * http://localhost:10152/api/clients
 * http://localhost:10152/api/logos
 * http://localhost:10152/api/operations
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PfsStatisticsApplication {

	@Bean
	public ModelMapper modelMapper() {
		final ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);
		return mapper;
	}

    public static void main(final String[] args) {
		SpringApplication.run(PfsStatisticsApplication.class, args);
	}

}
