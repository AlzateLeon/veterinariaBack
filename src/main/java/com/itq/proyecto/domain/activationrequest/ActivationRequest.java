package com.itq.proyecto.domain.activationrequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ActivationRequest {
    private String email;
    private String activationToken;
    private Date expirationDate;

    public ActivationRequest(String email) {
        this.email = email;
        this.activationToken = UUID.randomUUID().toString();
        // Establece una expiración, por ejemplo, 24 horas después de la creación.
        this.expirationDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
    }

}
