package com.diino.paymentSignature.service.preference;

import com.diino.paymentSignature.dto.PreferenceDTO;
import com.diino.paymentSignature.mapper.PreferenceMapper;
import com.diino.paymentSignature.repository.PreferencesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPreferenceService {
    private final PreferencesRepository repository;

    public ListPreferenceService(PreferencesRepository repository) {
        this.repository = repository;
    }

    public List<PreferenceDTO> execute( Long paymentAppID, Long credentialId) {
        return repository.findByAppIdAndCredentialId(paymentAppID,credentialId).stream()
                .map(PreferenceMapper::toDTO)
                .collect(Collectors.toList());
    }

}
