package com.diino.paymentSignature.service.paymentApp;

import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPaymentAppService {
    private final PaymentAppRepository repository;

    public ListPaymentAppService(PaymentAppRepository repository) {
        this.repository = repository;
    }

    public List<PaymentAppDTO> execute(){
        return repository.findAll().stream().map(PaymentAppDTO::new).collect(Collectors.toList());
    }
}
