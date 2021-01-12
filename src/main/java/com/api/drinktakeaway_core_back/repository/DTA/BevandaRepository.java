package com.api.drinktakeaway_core_back.repository.DTA;

import com.api.drinktakeaway_core_back.entity.DTA.Bevanda;
import com.api.drinktakeaway_core_back.entity.DTA.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BevandaRepository extends JpaRepository<Bevanda, Integer> {

    public List<Locale> findByLocali_Id(int id);

}
