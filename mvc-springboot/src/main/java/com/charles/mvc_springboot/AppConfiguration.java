package com.charles.mvc_springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
    @PropertySource
    (
        value = "classpath:values.properties", //Para que tome nuestro archivo properties creado
        encoding = "UTF-8" //Para que el archivo de configuración acepte caracteres especiales 
    )
)
public class AppConfiguration {

}
