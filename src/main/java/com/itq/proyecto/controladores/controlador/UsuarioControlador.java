package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultaCitaFiltrosInDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultasCitasUserOutDTO;
import com.itq.proyecto.domain.dtos.usuario.*;
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
    public CreacionUsuarioOutDTO crearUsuario(
            @RequestBody CreacionUsuarioIn creacionUsuarioIn
    ) {
        CreacionUsuarioOutDTO creacionUsuario = creacionUsuarioServicio.crearUsuario(creacionUsuarioIn);
        return creacionUsuario;
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

    @RequestMapping(value = "/mandarCorreoValidacion", method = RequestMethod.POST)
    public ResultadoDTO mandarCorreoValidacion(
            @RequestBody EnvioCorreoInDTO envioCorreoInDTO
    ) {
        return creacionUsuarioServicio.mandarCorreoValidacion(envioCorreoInDTO);
    }

    @RequestMapping(value = "/activarCuenta", method = RequestMethod.POST)
    public ResultadoDTO activarCuenta(
            @RequestBody ActivarCuentaDTO activarCuentaDTO) {

        return creacionUsuarioServicio.activarCuenta(activarCuentaDTO);
    }

    @RequestMapping(value = "/consultarUsuariosFiltros", method = RequestMethod.POST)
    public ConsultaUsuariosFiltrosOutDTO consultarUsuariosFiltros(
            @RequestBody ConsultaUsuariosFiltrosInDTO inDTO
    ){
        return creacionUsuarioServicio.consultarCitasFiltros(inDTO);
    }

}
