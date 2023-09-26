package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.CreacionUsuarioIn;
import com.itq.proyecto.dtos.CreacionUsuarioOut;
import com.itq.proyecto.dtos.UsuarioDTO;
import com.itq.proyecto.servicio.CreacionUsuarioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping
    public UsuarioDTO consultarUsuario(
        String user, String contrasena
    ){
        return creacionUsuarioServicio.consutarUsuarioExistente(user, contrasena);

    }
}
