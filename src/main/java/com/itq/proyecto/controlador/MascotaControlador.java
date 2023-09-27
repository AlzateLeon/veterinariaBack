package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.dtos.mascota.MascotaDTO;
import com.itq.proyecto.servicio.CreacionMascotaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaControlador {

    private final CreacionMascotaServicio creacionMascotaServicio;

    public MascotaControlador(CreacionMascotaServicio creacionMascotaServicio) {
        this.creacionMascotaServicio = creacionMascotaServicio;
    }

    @PostMapping
    public ResultadoDTO crearMascota(
            @RequestBody CreacionMascotaInDTO creacionMascotaInDTO
    ) {
        return creacionMascotaServicio.crearMascota(creacionMascotaInDTO);

    }

    @GetMapping
    public List<MascotaDTO> consultarMascotasUsuario(
            Long id
    ){
        return creacionMascotaServicio.consutarMascotasPorUsuario(id);

    }
}
