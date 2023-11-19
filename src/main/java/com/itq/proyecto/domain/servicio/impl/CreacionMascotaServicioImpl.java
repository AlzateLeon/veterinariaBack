package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import com.itq.proyecto.domain.dtos.citamedica.CitaMedicaDTO;
import com.itq.proyecto.domain.dtos.mascota.ConsultaMascotasUsuarioOutDTO;
import com.itq.proyecto.domain.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.domain.dtos.mascota.EditarMascotaInDTO;
import com.itq.proyecto.domain.dtos.mascota.MascotaDTO;
import com.itq.proyecto.domain.enums.TipoMascota;
import com.itq.proyecto.repositorio.RepositorioCita;
import com.itq.proyecto.repositorio.entidades.CitaMedica;
import com.itq.proyecto.repositorio.entidades.Mascota;
import com.itq.proyecto.domain.servicio.CreacionMascotaServicio;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreacionMascotaServicioImpl implements CreacionMascotaServicio {

    @Autowired
    private RepositorioMascota repositorioMascota;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    private RepositorioCita repositorioCita;

    private static final Logger logger = LogManager.getLogger(CreacionMascotaServicioImpl.class);

    @Override
    public ResultadoDTO crearMascota(CreacionMascotaInDTO creacionIn) {

        logger.info("dto entrada {}", creacionIn);
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try {

            TipoMascota tipoMascota = TipoMascota.fromString(creacionIn.getTipoMascota());

            Mascota mascota = new Mascota();
            mascota.setTipoMascota(tipoMascota);
            mascota.setRaza(creacionIn.getRaza());
            mascota.setEdad(creacionIn.getEdad());
            mascota.setNombre(creacionIn.getNombre());
            mascota.setDueno(repositorioUsuario.getReferenceById(creacionIn.getIdDueno()));
            mascota.setImagen(creacionIn.getImagenMascota());

            repositorioMascota.save(mascota);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la mascota, causa: " + e.getMessage());
        }

         return  resultadoDTO;
    }

    @Override
    public ConsultaMascotasUsuarioOutDTO consutarMascotasPorUsuario(Long idUser) {

        logger.debug("inicio del metodo consutarMascotasPorUsuario");
        ConsultaMascotasUsuarioOutDTO outDTO = new ConsultaMascotasUsuarioOutDTO();
        outDTO.setExitoso(true);
        List<MascotaDTO> mascotasDTO = new ArrayList<>();

        try {
            Optional<List<Mascota>> mascotas =
                    repositorioMascota.findByDueno(repositorioUsuario.getReferenceById(idUser));

            if (mascotas.isPresent() && !mascotas.isEmpty()) {
                List<Mascota> mascotas2 = mascotas.get();
                for (Mascota mascota : mascotas2) {
                    MascotaDTO mascotaDTO = new MascotaDTO();
                    mascotaDTO.setTipoMascota(mascota.getTipoMascota());
                    mascotaDTO.setRaza(mascota.getRaza());
                    mascotaDTO.setEdad(mascota.getEdad());
                    mascotaDTO.setId(mascota.getIdMascota());
                    mascotaDTO.setNombre(mascota.getNombre());
                    mascotaDTO.setImagenMascota(mascota.getImagen());
                    List<CitaMedica> citas =  repositorioCita.findAllByMascota(mascota);
                    List<CitaMedicaDTO> listaServicios = new ArrayList<>();
                    if (!citas.isEmpty()){
                        for (CitaMedica citaMedica:citas) {
                            CitaMedicaDTO citaMedicaDTO = new CitaMedicaDTO();
                            citaMedicaDTO.setNombreVacuna(citaMedica.getVacuna() != null ?
                                    citaMedica.getVacuna().getNombre() : "");
                            citaMedicaDTO.setNombreVeterinario(citaMedica.getVeterinario() != null ?
                                    citaMedica.getVeterinario().getNombre() : "");
                            citaMedicaDTO.setFecha(citaMedica.getFecha());
                            listaServicios.add(citaMedicaDTO);
                        }
                    }
                    mascotaDTO.setListaServicios(listaServicios);

                    mascotasDTO.add(mascotaDTO);
                }
            }
        } catch (Exception e) {
            logger.error("ERROR" + e.getMessage());
            outDTO.setExitoso(false);
            outDTO.setMensaje(e.getMessage());
        }

        logger.debug("fin del metodo consutarMascotasPorUsuario");
       outDTO.setListaMascotas(mascotasDTO);
       return outDTO;
    }

    @Override
    public ResultadoDTO editarMascota(EditarMascotaInDTO editarMascotaInDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try{
            Optional<Mascota> mascota = repositorioMascota.findByIdMascota(editarMascotaInDTO.getIdMascota());

            if (mascota.isPresent()){
                Mascota mascota1 = mascota.get();
                mascota1.setTipoMascota(editarMascotaInDTO.getTipoMascota());
                mascota1.setNombre(editarMascotaInDTO.getNombre());
                mascota1.setEdad(editarMascotaInDTO.getEdad());
                mascota1.setRaza(editarMascotaInDTO.getRaza());
                mascota1.setImagen(editarMascotaInDTO.getImagen());
                mascota1.setObservacion(editarMascotaInDTO.getObservacion());

                repositorioMascota.save(mascota1);
            }

        } catch(Exception e){
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje(e.getMessage());
        }

        return resultadoDTO;
    }
}
