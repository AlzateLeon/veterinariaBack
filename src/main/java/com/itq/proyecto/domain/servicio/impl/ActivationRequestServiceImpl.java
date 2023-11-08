package com.itq.proyecto.domain.servicio.impl;

import com.itq.proyecto.domain.activationrequest.ActivationRequest;
import com.itq.proyecto.domain.servicio.ActivationRequestService;
import com.itq.proyecto.repositorio.RepositorioActivationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivationRequestServiceImpl implements ActivationRequestService {

    @Autowired
    public RepositorioActivationRequest repositorioActivationRequest;

    //private List<ActivationRequest> activationRequests = new ArrayList<>();

    @Override
    public void addActivationRequest(ActivationRequest request) {
        repositorioActivationRequest.save(request);
    }

    @Override
    public ActivationRequest getActivationRequestByToken(String token) {
        Optional<ActivationRequest> request = repositorioActivationRequest.findByToken(token);

        if (request.isPresent()){
           return  request.get();
        }

        return null;
    }

    @Override
    public String solicitarActivacion(String correoDestino) {
        return null;
    }
}
