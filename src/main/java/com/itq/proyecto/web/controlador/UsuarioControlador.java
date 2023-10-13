package com.itq.proyecto.web.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioIn;
import com.itq.proyecto.domain.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.domain.dtos.usuario.EditarUsuarioMascotaInDTO;
import com.itq.proyecto.domain.dtos.usuario.UsuarioDTO;
import com.itq.proyecto.domain.servicio.CreacionUsuarioServicio;
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
        String correo, String contrasena
    ){
        return creacionUsuarioServicio.consutarUsuarioExistenteCorreoContraena(correo, contrasena);

    }

    @RequestMapping(value = "/editarUsuario", method = RequestMethod.POST)
    public ResultadoDTO editarUsuarioMascota(
            @RequestBody EditarUsuarioMascotaInDTO editarusuarioMascotaIn
    ) {
        return creacionUsuarioServicio.editarUsuarioMascota(editarusuarioMascotaIn);
    }
}
