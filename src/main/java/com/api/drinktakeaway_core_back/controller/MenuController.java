package com.api.drinktakeaway_core_back.controller;

import com.api.drinktakeaway_core_back.entity.DTA.Menu;
import com.api.drinktakeaway_core_back.repository.DTA.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/core")
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/get_all_menu")
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @GetMapping(value = "/menu/maxprice/{maxprice}")
    public List<Menu> filterByMaxPrice(@PathVariable(value = "maxprice") float maxPrice) {
        return menuRepository.findBevandaWithMaxPrice(maxPrice);
    }

    @GetMapping(value = "/menu/{idLocale}")
    public List<Menu> getMenuByIdLocale(@PathVariable(value = "idLocale") Integer idLocale) {
        return menuRepository.findMenuLocaleByIdLocale(idLocale);
    }

    @GetMapping(value = "/menu/bevanda/{idBevanda}")
    public List<Menu> getLocaliByIdBevanda(@PathVariable(value = "idBevanda") Integer idBevanda) {
        return menuRepository.findLocaliByIdBevanda(idBevanda);
    }

    @GetMapping(value = "/menu")
    @ResponseBody
    public List<Menu> getMenuByNameLocale(@RequestParam String nameLocale) {
        return menuRepository.findMenuByNomeLocale(nameLocale);
    }

    @GetMapping(value = "/specificdrinktype")
    @ResponseBody
    public List<Menu> getBevandaByNameLocaleTypeBevanda(@RequestParam String nameLocale,
            @RequestParam String typeBevanda) {
        return menuRepository.findBevandaByNomeLocaleTypeBevanda(nameLocale, typeBevanda);
    }

    @GetMapping(value = "/menu/{idLocale}/{idBevanda}")
    public Menu getMenuByIds(@PathVariable(value = "idLocale") Integer idLocale,
            @PathVariable(value = "idBevanda") Integer idBevanda) {
        return menuRepository.findMenuByIDs(idLocale, idBevanda);
    }

}