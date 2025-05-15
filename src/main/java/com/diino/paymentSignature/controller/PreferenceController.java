package com.diino.paymentSignature.controller;

import com.diino.paymentSignature.dto.PreferenceDTO;
import com.diino.paymentSignature.service.preference.ListPreferenceService;
import com.diino.paymentSignature.service.preference.SavePreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/paymentApp/{app_id}/credential/{credential_id}/preference")
public class PreferenceController {

    private final SavePreferenceService savePreferenceService;
    private final ListPreferenceService listPreferenceService;

    public PreferenceController(
            SavePreferenceService savePreferenceService,
            ListPreferenceService listPreferenceService
    ) {
        this.savePreferenceService = savePreferenceService;
        this.listPreferenceService = listPreferenceService;
    }

    @GetMapping
    public ResponseEntity<List<PreferenceDTO>> get(
            @PathVariable(name = "app_id") Long paymentAppID,
            @PathVariable(name = "credential_id") Long credentialId
    ) {
        List<PreferenceDTO> result = listPreferenceService.execute(paymentAppID, credentialId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<PreferenceDTO> save(
            @PathVariable(name = "app_id") Long paymentAppID,
            @PathVariable(name = "credential_id") Long credentialId,
            @RequestBody PreferenceDTO dto
    ) {
        PreferenceDTO result = savePreferenceService.execute(paymentAppID, credentialId,null,  dto);
        return ResponseEntity.ok(result);
    }

}
