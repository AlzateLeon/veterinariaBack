package com.itq.proyecto.dtos.mascota;

import com.itq.proyecto.dtos.ResultadoDTO;
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
