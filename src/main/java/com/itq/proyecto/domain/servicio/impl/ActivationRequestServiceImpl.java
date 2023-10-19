package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import com.itq.proyecto.domain.servicio.ActivationRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ActivationRequestServiceImpl implements ActivationRequestService {

    private List<ActivationRequest> activationRequests = new ArrayList<>();

    @Override
    public void addActivationRequest(ActivationRequest request) {
        activationRequests.add(request);
    }

    @Override
    public ActivationRequest getActivationRequestByToken(String token) {
        return activationRequests.stream()
                .filter(request -> request.getActivationToken().equals(token))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String solicitarActivacion(String correoDestino) {
        return null;
    }
}
