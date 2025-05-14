package com.diino.paymentSignature.controller;

import com.diino.paymentSignature.dto.PaymentCredentialDTO;
import com.diino.paymentSignature.service.paymentCredential.SavePaymentCredentialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paymentApp/{app_id}/credential")
public class PaymentCredentialController {

    private final SavePaymentCredentialService savePaymentCredentialService;

    public PaymentCredentialController(
            SavePaymentCredentialService savePaymentCredentialService
    ) {
        this.savePaymentCredentialService = savePaymentCredentialService;
    }


    @PostMapping
    public ResponseEntity<PaymentCredentialDTO> create(@PathVariable(name = "app_id") Long paymentAppID, @RequestBody @Valid PaymentCredentialDTO dto) {
        PaymentCredentialDTO result = savePaymentCredentialService.execute(paymentAppID, null, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
}
