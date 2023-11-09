package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.domain.dtos.vacuna.AplicacionVacunaInDTO;
import com.itq.proyecto.domain.dtos.vacuna.CreacionVacunaInDTO;
import com.itq.proyecto.domain.servicio.VacunaServicio;
import org.springframework.web.bind.annotation.*;

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
            AplicacionVacunaInDTO aplicacionVacunaInDTO
    ){
        return vacunaServicio.aplicarVacuna(aplicacionVacunaInDTO);
    }

}
