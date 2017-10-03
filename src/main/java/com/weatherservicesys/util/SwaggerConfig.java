package com.weatherservicesys.util;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket sort() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("weatherData").apiInfo(apiInfo()).select()
				.paths(regex("/weatherData.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Weather API").description("Weather services API")
				.termsOfServiceUrl("http://localhost:8080").contact("")
				.license("License Version 1.0 for Weather API").licenseUrl("http://localhost:8080").version("1.0")
				.build();
	}

}
