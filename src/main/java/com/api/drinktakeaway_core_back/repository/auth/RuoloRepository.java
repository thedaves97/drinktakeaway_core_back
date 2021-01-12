package com.api.drinktakeaway_core_back.repository.auth;

import com.api.drinktakeaway_core_back.entity.auth.Ruolo;
import com.api.drinktakeaway_core_back.enums.RuoloEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {

    Optional<Ruolo> findByRuoloEnum(RuoloEnum ruoloEnum);

    boolean existsByRuoloEnum(RuoloEnum ruoloEnum);
}