package com.codestock.codeStockBackEnd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig is a configuration class for Cross-Origin Resource Sharing (CORS) in the CodeStock API.
 * It uses Spring's @Configuration annotation to indicate that it's a configuration class.
 * It implements the WebMvcConfigurer interface to provide CORS configuration.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings.
     * This method is overridden from the WebMvcConfigurer interface.
     * It adds a CORS mapping for all paths ("/**") and allows all origins, methods, and headers.
     *
     * @param registry The CorsRegistry to which the CORS mappings are added.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}