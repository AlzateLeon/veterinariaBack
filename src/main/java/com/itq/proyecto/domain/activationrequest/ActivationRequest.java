package com.itq.proyecto.domain.activationrequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "activation_request")
@Entity
public class ActivationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long idActivation;

    @Column(nullable = true, name = "EMAIL")
    private String email;

    @Column(nullable = true, name = "TOKEN")
    private String token;

    @Column(nullable = true, name = "DATE")
    private Date expirationDate;

    public ActivationRequest(String email) {
        this.email = email;
        this.token = UUID.randomUUID().toString();
        // Establece una expiración, por ejemplo, 24 horas después de la creación.
        this.expirationDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
    }

}
