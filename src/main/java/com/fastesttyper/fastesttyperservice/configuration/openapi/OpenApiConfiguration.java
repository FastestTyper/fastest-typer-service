package com.fastesttyper.fastesttyperservice.configuration.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableWebMvc
public class OpenApiConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fastesttyper.fastesttyperservice.infrastructure.api.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Fastest Typer Service API",
                "Fastest Typer API Description",
                "1.0",
                "",
                new Contact("Fastest Typer", "https://github.com/FastestTyper", "sergio.gsanchez97@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
