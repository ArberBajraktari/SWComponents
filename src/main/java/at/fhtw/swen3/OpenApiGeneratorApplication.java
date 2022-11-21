package at.fhtw.swen3;

import com.fasterxml.jackson.databind.Module;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("at.fhtw.swen3.persistence.repositories")
@EntityScan
@Slf4j
@ComponentScan(basePackages = {"org.openapitools", "at.fhtw.swen3.controller.rest" , "at.fhtw.swen3.configuration"})
public class OpenApiGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
        log.info("testing logging with lombok");
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}