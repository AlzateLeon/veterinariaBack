package com.itq.proyecto.controlador;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.dtos.mascota.MascotaDTO;
import com.itq.proyecto.dtos.vacuna.CreacionVacunaInDTO;
import com.itq.proyecto.servicio.CreacionMascotaServicio;
import com.itq.proyecto.servicio.VacunaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vacuna")
@CrossOrigin(origins = "http://localhost:4200")
public class VacunaControlador {

    private final VacunaServicio vacunaServicio;

    public VacunaControlador(VacunaServicio vacunaServicio) {
        this.vacunaServicio = vacunaServicio;
    }

    @RequestMapping(value = "/crearVacuna", method = RequestMethod.POST)
    public ResultadoDTO crearVacuna(
            @RequestBody CreacionVacunaInDTO creacionVacunaInDTO
    ) {
        return vacunaServicio.crearVacuna(creacionVacunaInDTO);

    }

    @RequestMapping(value = "/aplicarVacuna", method = RequestMethod.POST)
    public ResultadoDTO aplicarVacuna(
             Long idvacuna, Long idMascota
    ){
        return vacunaServicio.aplicarVacuna(idvacuna, idMascota);

    }
}
