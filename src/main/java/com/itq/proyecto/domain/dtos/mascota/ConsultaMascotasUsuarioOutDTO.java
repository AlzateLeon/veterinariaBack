package com.itq.proyecto.domain.dtos.mascota;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaMascotasUsuarioOutDTO extends ResultadoDTO {

    private List<MascotaDTO> listaMascotas;


}
