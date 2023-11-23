package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.CitaMedicaDTO;
import com.itq.proyecto.domain.dtos.citamedica.ConsultaCitaFiltrosInDTO;
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
            citaMedica.setUsuario(repositorioUsuario.findByIdUser(creacionCitaInDTO.getIdUser()).get());
            citaMedica.setObservaciones(creacionCitaInDTO.getObservacion());

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
                    CitaMedicaDTO citaMedicaDTO =  convertirCitacitaDTO(cita);
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

    private CitaMedicaDTO convertirCitacitaDTO(CitaMedica cita) {
        CitaMedicaDTO citaMedicaDTO = new CitaMedicaDTO();
        citaMedicaDTO.setId(cita.getId());
        citaMedicaDTO.setHora(cita.getHora());
        citaMedicaDTO.setEstadoCitaMedicaEnum(cita.getEstadoCitaMedicaEnum());
        citaMedicaDTO.setFecha(cita.getFecha());
        citaMedicaDTO.setNombreVeterinario(cita.getVeterinario() != null ?
                cita.getVeterinario().getNombre(): "");
        citaMedicaDTO.setNombreMascota(cita.getMascota().getNombre());
        citaMedicaDTO.setTipoCitaMascotaEnum(cita.getTipoCitaMascotaEnum());
        citaMedicaDTO.setNombreVacuna(cita.getVacuna()!= null ?
                cita.getVacuna().getNombre() : "");
        citaMedicaDTO.setObservaciones(cita.getObservaciones());
        citaMedicaDTO.setNombreUsuario(cita.getUsuario() != null ?
                cita.getUsuario().getNombre() : "");
        citaMedicaDTO.setObservaciones(cita.getObservaciones());

        return citaMedicaDTO;
    }

    @Override
    public ResultadoDTO cancelarCita(Long idCita) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try {
            Optional<CitaMedica> citaOptional = repositorioCita.findById(idCita);

            if (citaOptional.isPresent()){

                CitaMedica cita = citaOptional.get();

                if (cita.getEstadoCitaMedicaEnum().equals(EstadoCitaMedicaEnum.CANCELADA)){
                    resultadoDTO.setExitoso(false);
                    resultadoDTO.setMensaje("La cita ya se encuentra cancelada");
                    return resultadoDTO;
                }
                cita.setEstadoCitaMedicaEnum(EstadoCitaMedicaEnum.CANCELADA);
                repositorioCita.save(cita);
            }
        } catch (Exception e){
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al cancelar la cita, causa: " + e.getMessage());
        }
        return resultadoDTO;
    }


    @Override
    public ConsultasCitasUserOutDTO consultarCitasFiltros(ConsultaCitaFiltrosInDTO inDTO) {
        ConsultasCitasUserOutDTO resultadoDTO = new ConsultasCitasUserOutDTO();
        resultadoDTO.setExitoso(true);

        try {

            List<CitaMedicaDTO> listaCitasMedicas = new ArrayList<>();
            Long idUser = null;
            Optional<Usuario> usuario = repositorioUsuario.findByCedula(inDTO.getCedula());
            if (usuario.isPresent()){
                idUser = usuario.get().getIdUser();
            }
            List<CitaMedica> citas = repositorioCita.buscarPorParametros(
                    inDTO.getFecha(), idUser, inDTO.getEstado());

            if (!citas.isEmpty()){
                for (CitaMedica cita:
                     citas) {
                    listaCitasMedicas.add(convertirCitacitaDTO(cita));
                }
            }

            resultadoDTO.setListaCitasMedicas(listaCitasMedicas);
        } catch (Exception e){
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al consultar las citas, causa: " + e.getMessage());
        }
        return resultadoDTO;
    }
}
