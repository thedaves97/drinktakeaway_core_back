package com.api.drinktakeaway_core_back.controller;

import com.api.drinktakeaway_core_back.entity.auth.Utente;
import com.api.drinktakeaway_core_back.repository.auth.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//  import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
//  import net.guides.springboot2.springboot2jpacrudexample.model.Utente;
// import net.guides.springboot2.springboot2jpacrudexample.repository.UtenteRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    @GetMapping("/utenti")
    public List<Utente> getAllEmployees() {
        return utenteRepository.findAll();
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable(value = "id") Integer utenteID) {
        Optional<Utente> Utente = utenteRepository.findById(utenteID);
        return ResponseEntity.ok().body(Utente.get());
    }

    @GetMapping("/utente/ins/{id}/{user}/{pass}")
    public ResponseEntity<Utente> updateUtente(@PathVariable(value = "id") Integer UtenteId,
            @PathVariable(value = "user") String UtenteUser, @PathVariable(value = "pass") String UtentePass) {
        // Optional<Utente> Utente = utenteRepository.findById(UtenteId);

        Utente u = new Utente(UtenteUser, UtentePass);

        final Utente updatedUtente = utenteRepository.save(u);
        return ResponseEntity.ok(updatedUtente);
    }

    @DeleteMapping("/utente/del/{id}")
    public Map<String, Boolean> deleteUtente(@PathVariable(value = "id") Integer UtenteId) {
        Optional<Utente> Utente = utenteRepository.findById(UtenteId);

        Utente u = Utente.get();

        utenteRepository.delete(u);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public Optional<Utente> getByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }
}
