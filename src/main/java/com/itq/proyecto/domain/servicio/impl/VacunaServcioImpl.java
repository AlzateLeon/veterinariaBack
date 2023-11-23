package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.vacuna.*;
import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.domain.servicio.CitaServicio;
import com.itq.proyecto.repositorio.RepositorioCita;
import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Vacuna;
import com.itq.proyecto.domain.servicio.VacunaServicio;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioVacuna;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VacunaServcioImpl implements VacunaServicio {

    private RepositorioVacuna repositorioVacuna;
    private RepositorioMascota repositorioMascota;
    private RepositorioCita repositorioCita;

    @Override
    public ResultadoDTO crearVacuna(CreacionVacunaInDTO creacionIn) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{

            Vacuna vacuna = new Vacuna();
            vacuna.setNombre(creacionIn.getNombre());
            vacuna.setTipoMascota(creacionIn.getTipoMascota());
            vacuna.setObservaciones(creacionIn.getObservaciones());
            vacuna.setUnidades(creacionIn.getUnidadades());
            repositorioVacuna.save(vacuna);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la vacuna, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO aplicarVacuna(AplicacionVacunaInDTO aplicacionVacunaInDTO) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{

            //se actualiza la cita
            Optional<CitaMedica> cita = repositorioCita.
                    findById(aplicacionVacunaInDTO.getIdCita());
            CitaMedica citaMedica = cita.get();
            citaMedica.setEstadoCitaMedicaEnum(EstadoCitaMedicaEnum.EXITOSA);
            citaMedica.setFechaActualizacion(LocalDate.now());
            repositorioCita.save(citaMedica);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al aplicar la vacuna, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ConsultaVacunafiltrosOutDTO consultarVacunasFiltros(ConsultaVacunafiltrosInDTO inDTO) {
        ConsultaVacunafiltrosOutDTO outDTO = new ConsultaVacunafiltrosOutDTO();
        outDTO.setExitoso(true);
        List<Vacuna> listaVacunas = new ArrayList<>();
        List<VacunaDTO> listaVacunasDTO = new ArrayList<>();

        try{
            if (inDTO.getTipoMascota() != null){
               listaVacunas =  repositorioVacuna.consultarVacunasTipoMascota(inDTO.getTipoMascota());
            }
            else{
                listaVacunas = repositorioVacuna.findAll();
            }

            for (Vacuna vacuna: listaVacunas) {
                listaVacunasDTO.add(convertirVacunaVacunaDTO(vacuna));
            }

            outDTO.setListaVacunas(listaVacunasDTO);
        } catch (Exception e) {
            outDTO.setExitoso(false);
            outDTO.setMensaje("Error al consultar las vacunas, causa: " + e.getMessage());
        }
        return  outDTO;
    }

    private VacunaDTO convertirVacunaVacunaDTO(Vacuna vacuna) {
        VacunaDTO vacunaDTO = new VacunaDTO();
        vacunaDTO.setId(vacuna.getId());
        vacunaDTO.setNombre(vacuna.getNombre());
        vacunaDTO.setTipoMascota(vacuna.getTipoMascota());
        vacunaDTO.setObservaciones(vacuna.getObservaciones());
        vacunaDTO.setUnidadDisponible(vacuna.getUnidades());

        return  vacunaDTO;
    }
}
