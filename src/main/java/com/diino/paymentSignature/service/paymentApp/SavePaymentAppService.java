package com.diino.paymentSignature.service.paymentApp;

import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.mapper.AppMapper;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SavePaymentAppService {

    private final PaymentAppRepository repository;

    public SavePaymentAppService(PaymentAppRepository repository) {
        this.repository = repository;
    }

    public PaymentAppDTO execute(Long id, PaymentAppDTO dto){
        PaymentAppEntity paymentApp;

        if (id == null) {
            paymentApp = AppMapper.toEntity(dto);
        } else {
            paymentApp = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Aplicativo de pagamento não encontrado com ID: " + id));

            //Update the existing entity
            paymentApp.setTitle(dto.getTitle());
            paymentApp.setDescription(dto.getDescription());
            paymentApp.setUrlApp(dto.getUrlApp());
            paymentApp.setEnv(dto.getEnv());

        }
        repository.save(paymentApp);

        return AppMapper.toDTO(paymentApp);

    }


}
