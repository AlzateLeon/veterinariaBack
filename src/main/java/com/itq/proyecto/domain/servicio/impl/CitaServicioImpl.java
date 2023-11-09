package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.CitaMedicaDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultasCitasUserOutDTO;
import com.itq.proyecto.domain.dtos.citamedica.CreacionCitaInDTO;
import com.itq.proyecto.domain.enums.EstadoCitaMedicaEnum;
import com.itq.proyecto.domain.servicio.CitaServicio;
import com.itq.proyecto.repositorio.RepositorioCita;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.repositorio.RepositorioVacuna;
import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Mascota;
import com.itq.proyecto.repositorio.entidades.Usuario;
import com.itq.proyecto.repositorio.entidades.Vacuna;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CitaServicioImpl implements CitaServicio {

    private RepositorioCita repositorioCita;
    private RepositorioMascota repositorioMascota;
    private RepositorioUsuario repositorioUsuario;

    @Override
    public ResultadoDTO crearCita(CreacionCitaInDTO creacionCitaInDTO) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{

            CitaMedica citaMedica = new CitaMedica();
            citaMedica.setEstadoCitaMedicaEnum(EstadoCitaMedicaEnum.PROGRAMADA);

            Optional<Mascota> mascota = repositorioMascota.
                    findByIdMascota(creacionCitaInDTO.getIdMascota());
            citaMedica.setMascota(mascota.get());
            citaMedica.setFecha(creacionCitaInDTO.getFecha());
            citaMedica.setTipoCitaMascotaEnum(creacionCitaInDTO.getTipoCitaMascotaEnum());
            citaMedica.setHora(creacionCitaInDTO.getHora());
            citaMedica.setIdUser(creacionCitaInDTO.getIdUser());

            if (creacionCitaInDTO.getIdVeterinario() != null){
                Optional<Usuario> vet =  repositorioUsuario.
                        findByIdUser(creacionCitaInDTO.getIdVeterinario());
                citaMedica.setVeterinario(vet.get());
            }

            repositorioCita.save(citaMedica);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la cita, causa: " + e.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ConsultasCitasUserOutDTO consultarCitasUsuario(Long idUser) {
        ConsultasCitasUserOutDTO consultasCitasUserOutDTO = new ConsultasCitasUserOutDTO();
        consultasCitasUserOutDTO.setExitoso(true);

        try{

            List<CitaMedica> citas = repositorioCita.findAllByIdUser(idUser);
            List<CitaMedicaDTO> citasDTO = new ArrayList<>();

            if (!citas.isEmpty()){
                for(CitaMedica cita : citas){
                    CitaMedicaDTO citaMedicaDTO = new CitaMedicaDTO();
                    citaMedicaDTO.setId(cita.getId());
                    citaMedicaDTO.setHora(cita.getHora());
                    citaMedicaDTO.setEstadoCitaMedicaEnum(cita.getEstadoCitaMedicaEnum());
                    citaMedicaDTO.setFecha(cita.getFecha());
                    citaMedicaDTO.setNombreVeterinario(cita.getVeterinario() != null ?
                            cita.getVeterinario().getNombre(): "");
                    citaMedicaDTO.setNombreMascota(cita.getMascota().getNombre());
                    citaMedicaDTO.setTipoCitaMascotaEnum(cita.getTipoCitaMascotaEnum());

                    citasDTO.add(citaMedicaDTO);
                }
            }
            consultasCitasUserOutDTO.setListaCitasMedicas(citasDTO);

        } catch(Exception e){
            consultasCitasUserOutDTO.setExitoso(false);
            consultasCitasUserOutDTO.setMensaje("Error al consultar las citas, causa: " + e.getMessage());
        }

        return consultasCitasUserOutDTO;
    }
}
