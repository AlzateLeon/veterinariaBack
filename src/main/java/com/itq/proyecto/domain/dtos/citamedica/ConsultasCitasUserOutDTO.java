package com.itq.proyecto.domain.dtos.citamedica;

import com.itq.proyecto.domain.dtos.ResultadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConsultasCitasUserOutDTO extends ResultadoDTO {

    private List<CitaMedicaDTO> listaCitasMedicas;
}
