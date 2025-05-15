package com.diino.paymentSignature.service.preference;

import com.diino.paymentSignature.dto.PreferenceDTO;
import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.entity.PreferenceEntity;
import com.diino.paymentSignature.mapper.PreferenceMapper;
import com.diino.paymentSignature.repository.GatewayCredentialRepository;
import com.diino.paymentSignature.repository.PaymentAppRepository;
import com.diino.paymentSignature.repository.PreferencesRepository;
import com.diino.paymentSignature.service.paymentApp.SavePaymentAppService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SavePreferenceService {
    private final PreferencesRepository repository;
    private final PaymentAppRepository paymentAppRepository;
    private final GatewayCredentialRepository gatewayCredentialRepository;

    public SavePreferenceService(
            PreferencesRepository repository,
            PaymentAppRepository paymentAppRepository,
            GatewayCredentialRepository gatewayCredentialRepository
    ) {
        this.repository = repository;
        this.paymentAppRepository = paymentAppRepository;
        this.gatewayCredentialRepository = gatewayCredentialRepository;
    }


    public PreferenceDTO execute(Long paymentAppID, Long credentialID,Long preferenceID,  PreferenceDTO dto) {
        PreferenceEntity preference;
        // Buscar o aplicativo de pagamento associado
        PaymentAppEntity app = paymentAppRepository.findById(paymentAppID)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aplicativo de pagamento não encontrado com ID: " + paymentAppID));

        // Se o credentialId for nulo, cria uma nova credencial, caso contrário, busca a existente
        GatewayCredentialEntity paymentCredential = gatewayCredentialRepository.findById(credentialID)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Credencial não encontrada com ID: " + credentialID));

        if (preferenceID == null) {
            preference = PreferenceMapper.toEntity(dto);
            preference.setApp(app);
            preference.setCredential(paymentCredential); // <<== ESSENCIAL AQUI
        } else {
            preference = repository.findById(preferenceID)
                    .orElseThrow(() -> new EntityNotFoundException("Preferência não encontrada com ID: " + preferenceID));
            preference.setTitle(dto.getTitle());
            preference.setQuantity(dto.getQuantity());
            preference.setUnitPrice(dto.getUnitPrice());
            preference.setApp(app);
            preference.setCredential(paymentCredential);
        }

        repository.save(preference);

        return PreferenceMapper.toDTO(preference);

    }
}
