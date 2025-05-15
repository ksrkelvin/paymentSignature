package com.diino.paymentSignature.controller;

import com.diino.paymentSignature.dto.GatewayCredentialDTO;
import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.service.gatewayCredential.ListGatewayCredentialService;
import com.diino.paymentSignature.service.gatewayCredential.SaveGatewayCredentialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/paymentApp/{app_id}/credential")
public class GatewayCredentialController {

    private final SaveGatewayCredentialService saveGatewayCredentialService;
    private final ListGatewayCredentialService listGatewayCredentialService;

    public GatewayCredentialController(
            SaveGatewayCredentialService saveGatewayCredentialService,
            ListGatewayCredentialService listGatewayCredentialService
    ) {
        this.saveGatewayCredentialService = saveGatewayCredentialService;
        this.listGatewayCredentialService = listGatewayCredentialService;
    }

    @GetMapping
    public ResponseEntity<List<GatewayCredentialDTO>> get(@PathVariable(name = "app_id") Long paymentAppID) {
        List<GatewayCredentialDTO> result = listGatewayCredentialService.execute(paymentAppID);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<GatewayCredentialDTO> create(@PathVariable(name = "app_id") Long paymentAppID, @RequestBody @Valid GatewayCredentialDTO dto) {
        GatewayCredentialDTO result = saveGatewayCredentialService.execute(paymentAppID, null, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }


}
