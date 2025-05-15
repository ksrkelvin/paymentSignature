package com.diino.paymentSignature.service.gatewayCredential;

import com.diino.paymentSignature.dto.GatewayCredentialDTO;
import com.diino.paymentSignature.mapper.GatewayCredentialMapper;
import com.diino.paymentSignature.repository.GatewayCredentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListGatewayCredentialService {


    private final GatewayCredentialRepository repository;

    public ListGatewayCredentialService(GatewayCredentialRepository repository) {
        this.repository = repository;
    }

    public List<GatewayCredentialDTO> execute(Long appID) {
        return repository.findByAppId( appID)
                .stream()
                .map(GatewayCredentialMapper::toDTO)
                .collect(Collectors.toList());
    }

}
