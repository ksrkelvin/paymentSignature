package com.diino.paymentSignature.service.paymentApp;

import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SavePaymentAppService {

    private final PaymentAppRepository repository;

    public SavePaymentAppService(PaymentAppRepository repository) {
        this.repository = repository;
    }

    public PaymentAppDTO execute(Long id, PaymentAppDTO dto){
        PaymentAppEntity paymentApp;

        if (id == null) {
            paymentApp = new PaymentAppEntity();
        } else {
            paymentApp = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Aplicativo de pagamento não encontrado com ID: " + id));
        }

        paymentApp.setTitle(dto.getTitle());
        paymentApp.setDescription(dto.getDescription());
        paymentApp.setUrlApp(dto.getUrlApp());
        paymentApp.setEnv(dto.getEnv());
        paymentApp.setCreated(dto.getCreated());
        paymentApp.setUpdated(dto.getUpdated());

        repository.save(paymentApp);

        return new PaymentAppDTO(paymentApp);

    }


}
