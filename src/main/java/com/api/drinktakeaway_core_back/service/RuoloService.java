package com.api.drinktakeaway_core_back.service;

import com.api.drinktakeaway_core_back.entity.auth.Ruolo;
import com.api.drinktakeaway_core_back.enums.RuoloEnum;
import com.api.drinktakeaway_core_back.repository.auth.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RuoloService {

    @Autowired
    RuoloRepository ruoloRepository;

    public Optional<Ruolo> getbyRuoloEnum(RuoloEnum ruoloEnum) {
        return ruoloRepository.findByRuoloEnum(ruoloEnum);
    }

    public boolean existsbyRuoloEnum(RuoloEnum ruoloEnum) {
        return ruoloRepository.existsByRuoloEnum(ruoloEnum);
    }

    public void save(Ruolo ruolo) {
        ruoloRepository.save(ruolo);
    }
}
