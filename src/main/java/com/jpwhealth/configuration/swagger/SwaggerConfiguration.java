package com.jpwhealth.configuration.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(apis())
                .paths(regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("com.jpwhealth");
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("JPW HEALTH API")
                .description ("Aplicação que visa auxiliar no combate ao Corona Virús (COVID-19), elaborado durante as aulas do Curso de Análise e Desenvolvimento de Sistemas da Faculdade Senai Porto Alegre.")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .termsOfServiceUrl("/service.html")
                .version("1.0.0")
                .contact(new Contact(
                        "Willian Kaminski",
                        "https://willian-kaminski.github.io/",
                        "williankaminski.santos@gmail.com"))
                .build();

        return apiInfo;
    }

}
