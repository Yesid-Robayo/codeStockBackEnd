package com.codestock.codeStockBackEnd.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig is a configuration class for the OpenAPI documentation of the CodeStock API.
 * It uses Spring's @Configuration annotation to indicate that it's a configuration class.
 * It uses Swagger's @OpenAPIDefinition annotation to provide metadata for the OpenAPI documentation.
 */
@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
        title = "CodeStock API",
        version = "v1",
        description = "Apis for CodeStock Application"
))
public class OpenApiConfig {
    // This class doesn't have any attributes or methods.
    // It's only used for configuration purposes.
}