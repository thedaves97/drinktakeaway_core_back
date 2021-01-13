package com.api.drinktakeaway_core_back.controller;

import com.api.drinktakeaway_core_back.entity.DTA.Locale;
import com.api.drinktakeaway_core_back.repository.DTA.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class LocaleController {

    @Autowired
    private LocaleRepository localeRepository;

    @GetMapping("/getAllLocals")
    public List<Locale> getAllLocali() {
        return localeRepository.findAll();
    }

    @GetMapping(value = "/locale/getId")
    @ResponseBody
    public int getIdByNameLocale(@RequestParam String nameLocale) {
        return localeRepository.findIdByNomeLocale(nameLocale);
    }

}
