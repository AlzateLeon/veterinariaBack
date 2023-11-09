package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultasCitasUserOutDTO;
import com.itq.proyecto.domain.dtos.citamedica.CreacionCitaInDTO;
import com.itq.proyecto.domain.servicio.CitaServicio;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cita")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaContolador {

    private final CitaServicio citaServicio;

    public CitaContolador(@Qualifier("citaServicioImpl")
                          CitaServicio citaServicio) {
        this.citaServicio = citaServicio;
    }

    @RequestMapping(value = "/crearCita", method = RequestMethod.POST)
    @ApiResponse(description = "Metodo encargado de crear una cita",
            responseCode = "200")
    public ResultadoDTO crearCita(
            @RequestBody CreacionCitaInDTO creacionCitaInDTO
    ) {
        return citaServicio.crearCita(creacionCitaInDTO);

    }

    @RequestMapping(value = "/consultarCitasUsuario", method = RequestMethod.GET)
    public ConsultasCitasUserOutDTO consultarCitasUsuario(
            Long idUser
    ){
        return citaServicio.consultarCitasUsuario(idUser);
    }
}
