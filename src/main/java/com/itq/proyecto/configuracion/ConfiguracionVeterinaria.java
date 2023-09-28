package com.itq.proyecto.configuracion;

import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
import com.itq.proyecto.servicio.impl.CreacionUsuarioServicioImpl;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class ConfiguracionVeterinaria {

    @Bean
    @Primary
    public CreacionUsuarioServicio crearUsuarioServicio(RepositorioUsuario repositorioUsuario){
        return new CreacionUsuarioServicioImpl(repositorioUsuario);
    }

}
