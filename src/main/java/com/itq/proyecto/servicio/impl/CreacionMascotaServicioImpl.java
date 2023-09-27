package com.itq.proyecto.servicio.impl;

import com.itq.proyecto.dtos.ResultadoDTO;
import com.itq.proyecto.dtos.mascota.CreacionMascotaInDTO;
import com.itq.proyecto.dtos.mascota.MascotaDTO;
import com.itq.proyecto.dtos.usuario.CreacionUsuarioOut;
import com.itq.proyecto.dtos.usuario.UsuarioDTO;
import com.itq.proyecto.entidades.Mascota;
import com.itq.proyecto.entidades.Usuario;
import com.itq.proyecto.repositorio.RepositorioMascota;
import com.itq.proyecto.repositorio.RepositorioUsuario;
import com.itq.proyecto.servicio.CreacionMascotaServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreacionMascotaServicioImpl implements CreacionMascotaServicio {

    private RepositorioMascota repositorioMascota;
    private RepositorioUsuario repositorioUsuario;


    @Override
    public ResultadoDTO crearMascota(CreacionMascotaInDTO creacionIn) {

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(true);

        try {

            Mascota mascota = new Mascota();
            mascota.setTipoMascota(creacionIn.getTipoMascota());
            mascota.setRaza(creacionIn.getRaza());
            mascota.setEdad(creacionIn.getEdad());
            mascota.setNombre(creacionIn.getNombre());
            mascota.setDueno(repositorioUsuario.getReferenceById(creacionIn.getIdDueno()));

            repositorioMascota.save(mascota);

        } catch (Exception e) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear la mascota, causa: " + e.getMessage());
        }

         return  resultadoDTO;
    }

    @Override
    public List<MascotaDTO> consutarMascotasPorUsuario(Long idUser) {

        List<MascotaDTO> mascotasDTO = new ArrayList<>();
       Optional<List<Mascota>> mascotas =
               repositorioMascota.findByDueno(repositorioUsuario.getReferenceById(idUser));

       if (mascotas.isPresent() && !mascotas.isEmpty()){
           List<Mascota> mascotas2 = mascotas.get();
           for (Mascota mascota: mascotas2) {
               MascotaDTO mascotaDTO = new MascotaDTO();
               mascotaDTO.setTipoMascota(mascota.getTipoMascota());
               mascotaDTO.setRaza(mascota.getRaza());
               mascotaDTO.setEdad(mascota.getEdad());
               mascotaDTO.setId(mascota.getId());
               mascotaDTO.setNombre(mascota.getNombre());

               mascotasDTO.add(mascotaDTO);
           }
       }

       return mascotasDTO;
    }
}
