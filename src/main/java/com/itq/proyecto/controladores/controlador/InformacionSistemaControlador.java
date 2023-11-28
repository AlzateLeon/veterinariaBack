package com.itq.proyecto.controladores.controlador;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.informacionsistema.InformacionSistemaDTO;
import com.itq.proyecto.domain.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.domain.servicio.CreacionMascotaServicio;
import com.itq.proyecto.domain.servicio.InformacionSistemaServicio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("informacionSistema")
public class InformacionSistemaControlador {

    private final InformacionSistemaServicio informacionSistemaServicio;

    public InformacionSistemaControlador(@Qualifier("informacionSistemaServicioImpl")
                                         InformacionSistemaServicio informacionSistemaServicio) {
        this.informacionSistemaServicio = informacionSistemaServicio;
    }

    @RequestMapping(value = "/consultarInformacionActual", method = RequestMethod.GET)
    public InformacionSistemaDTO consultarInformacionActual(){
        return informacionSistemaServicio.consutarInformacionSistemaActual();
    }

    @RequestMapping(value = "/editarInformacionActual", method = RequestMethod.POST)
    public ResultadoDTO consultarInformacionActual(
            @RequestBody  InformacionSistemaDTO info){
        return informacionSistemaServicio.editarInformacionActual(info);
    }
}
