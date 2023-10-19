package com.itq.proyecto.domain.configuracion;

import com.itq.proyecto.domain.servicio.ActivationRequestService;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.domain.servicio.CreacionMascotaServicio;
import com.itq.proyecto.domain.servicio.CreacionUsuarioServicio;
import com.itq.proyecto.domain.servicio.impl.CreacionMascotaServicioImpl;
import com.itq.proyecto.domain.servicio.impl.CreacionUsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
public class ConfiguracionVeterinaria {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public CreacionUsuarioServicio crearUsuarioServicio(RepositorioUsuario repositorioUsuario,
                                                        JavaMailSender javaMailSender,
                                                        ActivationRequestService activationRequestService){
        return new CreacionUsuarioServicioImpl(repositorioUsuario, javaMailSender ,activationRequestService);
    }

    @Bean
    public CreacionMascotaServicio crearMascotaService(RepositorioMascota repositorioMascota,
                                                       RepositorioUsuario repositorioUsuario){
        return new CreacionMascotaServicioImpl(repositorioMascota, repositorioUsuario);
    }

    @Configuration
    public class CorsConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost:4200") // Permite solicitudes desde este origen
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
                }
            };
        }
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
        javaMailProperties.setProperty("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }

}
