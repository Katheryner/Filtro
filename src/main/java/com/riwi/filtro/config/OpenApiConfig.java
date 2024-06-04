package com.riwi.filtro.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para administrar eventos", version = "1.0", description = "Documentación api de administración de eventos"))
public class OpenApiConfig {

}