package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.informacionsistema.InformacionSistemaDTO;
import com.itq.proyecto.domain.servicio.InformacionSistemaServicio;
import com.itq.proyecto.repositorio.RepositorioInformacionSistema;
import com.itq.proyecto.repositorio.entidades.InformacionSistema;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InformacionSistemaServicioImpl implements InformacionSistemaServicio {

    private RepositorioInformacionSistema repositorioInformacionSistema;

    @Override
    public InformacionSistemaDTO consutarInformacionSistemaActual() {
        InformacionSistemaDTO info = new InformacionSistemaDTO();
        info.setExitoso(true);

        try{
            Optional<InformacionSistema> infoOpt = repositorioInformacionSistema.findByActualTrue();

            if (infoOpt.isPresent()){
                InformacionSistema infoEntity = infoOpt.get();
                info.setId(infoEntity.getId());
                info.setTelefono(infoEntity.getTelefono());
                info.setCorreo(infoEntity.getCorreo());
                info.setUbicacion(infoEntity.getUbicacion());
                info.setHorariosAtencion(infoEntity.getHorariosAtencion());

            }else{
                info.setExitoso(false);
                info.setMensaje("Parametrización de información de sistema faltante");
            }

        } catch (Exception e) {
            info.setExitoso(false);
            info.setMensaje("Error al consultar la información actual del sistema, causa: " + e.getMessage());
        }

        return info;
    }

    @Override
    public ResultadoDTO editarInformacionActual(InformacionSistemaDTO info) {
        ResultadoDTO res = new ResultadoDTO();
        res.setExitoso(true);
        try{

            Optional<InformacionSistema> infoOpt = repositorioInformacionSistema.findById(info.getId());

            if (infoOpt.isPresent()){
                InformacionSistema informacionSistema = infoOpt.get();
                informacionSistema.setUbicacion(info.getUbicacion());
                informacionSistema.setTelefono(info.getTelefono());
                informacionSistema.setCorreo(info.getCorreo());
                informacionSistema.setHorariosAtencion(info.getHorariosAtencion());

                repositorioInformacionSistema.save(informacionSistema);
            }

        } catch (Exception e) {
            res.setExitoso(false);
            res.setMensaje("Error al editar la información actual del sistema, causa: " + e.getMessage());
        }

        return res;
    }
}
