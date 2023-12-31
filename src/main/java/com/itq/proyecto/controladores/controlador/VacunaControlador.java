package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.vacuna.AplicacionVacunaInDTO;
import com.itq.proyecto.domain.dtos.vacuna.ConsultaVacunafiltrosInDTO;
import com.itq.proyecto.domain.dtos.vacuna.ConsultaVacunafiltrosOutDTO;
import com.itq.proyecto.domain.dtos.vacuna.CreacionVacunaInDTO;
import com.itq.proyecto.domain.servicio.VacunaServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacuna")
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
            @RequestBody AplicacionVacunaInDTO aplicacionVacunaInDTO
    ){
        return vacunaServicio.aplicarVacuna(aplicacionVacunaInDTO);
    }

    @RequestMapping(value = "/consultarVacunasFiltros", method = RequestMethod.POST)
    public ConsultaVacunafiltrosOutDTO consultarMascotasUsuario(
            @RequestBody ConsultaVacunafiltrosInDTO inDTO
    ){
        return vacunaServicio.consultarVacunasFiltros(inDTO);
    }

    @RequestMapping(value = "/editarVacuna", method = RequestMethod.POST)
    public ResultadoDTO editarVacuna(
            @RequestBody CreacionVacunaInDTO creacionVacunaInDTO
    ) {
        return vacunaServicio.editarVacuna(creacionVacunaInDTO);

    }

}
