package com.itq.proyecto.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoMascota {

    PERRO,
    GATO,
    PEZ,
    CABALLO;

    @JsonCreator
    public static TipoMascota fromString(String value) {
        return valueOf(value.toUpperCase()); // Asegurarse de que se comparen en mayúsculas
    }

    @JsonValue
    public String toString() {
        return name().toUpperCase();
    }
}
