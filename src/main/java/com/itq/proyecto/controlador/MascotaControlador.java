package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.dtos.mascota.MascotaDTO;
import com.itq.proyecto.servicio.CreacionMascotaServicio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaControlador {

    private final CreacionMascotaServicio creacionMascotaServicio;

    public MascotaControlador(@Qualifier("creacionMascotaServicioImpl")
                              CreacionMascotaServicio creacionMascotaServicio) {
        this.creacionMascotaServicio = creacionMascotaServicio;
    }

    @PostMapping
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
}
