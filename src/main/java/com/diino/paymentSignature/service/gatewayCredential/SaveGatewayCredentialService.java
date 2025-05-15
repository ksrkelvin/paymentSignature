package com.diino.paymentSignature.service.gatewayCredential;

import com.diino.paymentSignature.dto.GatewayCredentialDTO;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.mapper.GatewayCredentialMapper;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import com.diino.paymentSignature.repository.GatewayCredentialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SaveGatewayCredentialService {

    private final GatewayCredentialRepository gatewayCredentialRepository;
    private final PaymentAppRepository paymentAppRepository;

    public SaveGatewayCredentialService(GatewayCredentialRepository gatewayCredentialRepository, PaymentAppRepository paymentAppRepository) {
        this.gatewayCredentialRepository = gatewayCredentialRepository;
        this.paymentAppRepository = paymentAppRepository;
    }

    public GatewayCredentialDTO execute(Long paymentAppID, Long credentialId, GatewayCredentialDTO dto){
        // Buscar o aplicativo de pagamento associado
        PaymentAppEntity app = paymentAppRepository.findById(paymentAppID)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aplicativo de pagamento não encontrado com ID: " + paymentAppID));

        // Se o credentialId for nulo, cria uma nova credencial, caso contrário, busca a existente
        GatewayCredentialEntity paymentCredential = (credentialId == null)
                ? new GatewayCredentialEntity()
                : gatewayCredentialRepository.findById(credentialId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Credencial não encontrada com ID: " + credentialId));

        // Setando os dados da credencial
        paymentCredential.setApp(app);
        paymentCredential.setPaymentProvider(dto.getPaymentProvider());
        paymentCredential.setAccessToken(dto.getAccessToken());
        paymentCredential.setPublicKey(dto.getPublicKey());


        // Salvar a credencial
        paymentCredential = gatewayCredentialRepository.save(paymentCredential);

        // Retornar o DTO mapeado
        return GatewayCredentialMapper.toDTO(paymentCredential);
    }
}
