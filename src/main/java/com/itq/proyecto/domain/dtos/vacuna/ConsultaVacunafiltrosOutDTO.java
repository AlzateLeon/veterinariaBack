package com.itq.proyecto.domain.dtos.vacuna;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaVacunafiltrosOutDTO  extends ResultadoDTO {

    private List<VacunaDTO> listaVacunas;
}
