package com.itq.proyecto.domain.servicio;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface ActivationRequestService {

    public void addActivationRequest(ActivationRequest request);

    public ActivationRequest getActivationRequestByToken(String token);

    public String solicitarActivacion(@RequestBody String correoDestino);
}
