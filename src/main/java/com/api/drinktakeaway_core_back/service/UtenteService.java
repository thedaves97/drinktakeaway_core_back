package com.api.drinktakeaway_core_back.service;

import com.api.drinktakeaway_core_back.entity.auth.Utente;
import com.api.drinktakeaway_core_back.repository.auth.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    public Optional<Utente> findbyEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    public boolean existsbyEmail(String email) {
        return utenteRepository.existsByEmail(email);
    }

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }
}
