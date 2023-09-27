package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.dtos.usuario.UsuarioDTO;
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

    @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
    public ResponseEntity<CreacionUsuarioOut> crearUsuario(
            @RequestBody CreacionUsuarioIn creacionUsuarioIn
    ) {
        CreacionUsuarioOut creacionUsuario = creacionUsuarioServicio.crearUsuario(creacionUsuarioIn);
        return new ResponseEntity<>(creacionUsuario,
                creacionUsuario.getHttpStatus()
        );
    }
    @RequestMapping(value = "/crearVeterinario", method = RequestMethod.POST)
    public ResultadoDTO crearUsuarioVeterinario(
            @RequestBody CreacionUsuarioIn creacionUsuarioIn
    ) {
        return creacionUsuarioServicio.crearVeterinario(creacionUsuarioIn);
    }


    @GetMapping
    public UsuarioDTO consultarUsuario(
        String user, String contrasena
    ){
        return creacionUsuarioServicio.consutarUsuarioExistente(user, contrasena);

    }
}
