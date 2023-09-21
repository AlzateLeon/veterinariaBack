package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veterinaria")
public class UsuarioControlador {

    private final CreacionUsuarioServicio creacionUsuarioServicio;

    public UsuarioControlador(CreacionUsuarioServicio creacionUsuarioServicio) {
        this.creacionUsuarioServicio = creacionUsuarioServicio;
    }

    @PostMapping
    public ResponseEntity<CreacionUsuarioOut> crearUsuario(
            @RequestBody CreacionUsuarioIn creacionUsuarioIn
    ) {
        CreacionUsuarioOut creacionUsuario = creacionUsuarioServicio.crearUsuario(creacionUsuarioIn);
        return new ResponseEntity<>(creacionUsuario,
                creacionUsuario.getHttpStatus()
        );
    }
}
