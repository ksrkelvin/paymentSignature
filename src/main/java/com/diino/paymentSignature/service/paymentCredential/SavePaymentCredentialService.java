package com.diino.paymentSignature.service.paymentCredential;

import com.diino.paymentSignature.controller.PaymentCredentialController;
import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.dto.PaymentCredentialDTO;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.entity.PaymentCredentialEntity;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import com.diino.paymentSignature.repository.PaymentCredentialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SavePaymentCredentialService {

    private final PaymentCredentialRepository paymentCredentialrepository;
    private final PaymentAppRepository paymentAppRepository;

    public SavePaymentCredentialService(PaymentCredentialRepository paymentCredentialrepository, PaymentAppRepository paymentAppRepository) {
        this.paymentCredentialrepository = paymentCredentialrepository;
        this.paymentAppRepository = paymentAppRepository;
    }

    public PaymentCredentialDTO execute(Long paymentAppID , Long credentialId, PaymentCredentialDTO dto){
        PaymentCredentialEntity paymentCredential;

        PaymentAppEntity app = paymentAppRepository.findById(paymentAppID)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aplicativo de pagamento não encontrado com ID: " + paymentAppID));

        paymentCredential = (credentialId == null)
                ? new PaymentCredentialEntity()
                : paymentCredentialrepository.findById(credentialId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Credencial não encontrada com ID: " + credentialId));



        paymentCredential.setApp(app);
        paymentCredential.setPaymentProvider(dto.getPaymentProvider());
        paymentCredential.setAccessToken(dto.getAccessToken());
        paymentCredential.setPublicKey(dto.getPublicKey());

        paymentCredentialrepository.save(paymentCredential);

        return new PaymentCredentialDTO(paymentCredential);

    }
}
