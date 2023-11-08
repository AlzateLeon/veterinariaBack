package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.domain.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.domain.dtos.mascota.EditarMascotaInDTO;
import com.itq.proyecto.domain.dtos.usuario.EditarUsuarioMascotaInDTO;
import com.itq.proyecto.domain.servicio.CreacionMascotaServicio;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaControlador {

    private final CreacionMascotaServicio creacionMascotaServicio;

    public MascotaControlador(@Qualifier("creacionMascotaServicioImpl")
                              CreacionMascotaServicio creacionMascotaServicio) {
        this.creacionMascotaServicio = creacionMascotaServicio;
    }

    @RequestMapping(value = "/crearMascota", method = RequestMethod.POST)
    @ApiResponse(description = "Metodo encargado de crear una mascota y asignarla a un usuario",
    responseCode = "200")
    public ResultadoDTO crearMascota(
            @RequestBody CreacionMascotaInDTO creacionMascotaInDTO
    ) {
        return creacionMascotaServicio.crearMascota(creacionMascotaInDTO);

    }

    @RequestMapping(value = "/mascotasUsuario", method = RequestMethod.GET)
    public ConsultaMascotasUsuarioOutDTO consultarMascotasUsuario(
            Long idUser
    ){
        return creacionMascotaServicio.consutarMascotasPorUsuario(idUser);

    }

    @RequestMapping(value = "/editarMascota", method = RequestMethod.POST)
    public ResultadoDTO editarMascota(
            @RequestBody EditarMascotaInDTO editarMascotaInDTO
    ) {
        return creacionMascotaServicio.editarMascota(editarMascotaInDTO);
    }
}
