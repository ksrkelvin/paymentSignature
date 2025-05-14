package com.diino.paymentSignature.controller;

import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.service.paymentApp.ListPaymentAppService;
import com.diino.paymentSignature.service.paymentApp.SavePaymentAppService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/paymentApp")
public class PaymentAppController {
    private final SavePaymentAppService savePaymentAppService;
    private final ListPaymentAppService listPaymentAppService;

    public PaymentAppController(
            SavePaymentAppService savePaymentAppService,
            ListPaymentAppService listPaymentAppService
    ) {
        this.savePaymentAppService = savePaymentAppService;
        this.listPaymentAppService = listPaymentAppService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentAppDTO>> list() {
        return ResponseEntity.ok(listPaymentAppService.execute());
    }
    @PostMapping
    public ResponseEntity<PaymentAppDTO> create(@RequestBody @Valid PaymentAppDTO dto) {
        PaymentAppDTO result = savePaymentAppService.execute(null, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
