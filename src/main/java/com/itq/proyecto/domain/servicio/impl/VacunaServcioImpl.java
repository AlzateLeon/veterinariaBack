package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.vacuna.CreacionVacunaInDTO;
import com.itq.proyecto.domain.entidades.Vacuna;
import com.itq.proyecto.domain.entidades.VacunaAplicada;
import com.itq.proyecto.domain.servicio.VacunaServicio;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioVacuna;
import com.itq.proyecto.repositorio.RepositorioVacunaAplicada;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VacunaServcioImpl implements VacunaServicio {

    private RepositorioVacuna repositorioVacuna;
    private RepositorioMascota repositorioMascota;
    private RepositorioVacunaAplicada repositorioVacunaAplicada;

    @Override
    public ResultadoDTO crearVacuna(CreacionVacunaInDTO creacionIn) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{

            Vacuna vacuna = new Vacuna();
            vacuna.setNombre(creacionIn.getNombre());
            vacuna.setTipoMascota(creacionIn.getTipoMascota());
            repositorioVacuna.save(vacuna);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la vacuna, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO aplicarVacuna(Long idvacuna, Long idMascota) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{

            VacunaAplicada vacunaAplicada = new VacunaAplicada();
            vacunaAplicada.setFechaAplicacion(LocalDate.now());
            vacunaAplicada.setMascota(repositorioMascota.getReferenceById(idMascota));
            vacunaAplicada.setVacuna(repositorioVacuna.getReferenceById(idvacuna));
            repositorioVacunaAplicada.save(vacunaAplicada);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al aplicar la vacuna, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }
}
