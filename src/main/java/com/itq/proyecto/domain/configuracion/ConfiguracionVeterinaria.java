package com.itq.proyecto.domain.configuracion;

import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.domain.servicio.CreacionMascotaServicio;
import com.itq.proyecto.domain.servicio.CreacionUsuarioServicio;
import com.itq.proyecto.domain.servicio.impl.CreacionMascotaServicioImpl;
import com.itq.proyecto.domain.servicio.impl.CreacionUsuarioServicioImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfiguracionVeterinaria {

    @Bean
    @Primary
    public CreacionUsuarioServicio crearUsuarioServicio(RepositorioUsuario repositorioUsuario){
        return new CreacionUsuarioServicioImpl(repositorioUsuario);
    }

    @Bean
    public CreacionMascotaServicio crearMascotaService(RepositorioMascota repositorioMascota,
                                                       RepositorioUsuario repositorioUsuario){
        return new CreacionMascotaServicioImpl(repositorioMascota, repositorioUsuario);
    }

}
