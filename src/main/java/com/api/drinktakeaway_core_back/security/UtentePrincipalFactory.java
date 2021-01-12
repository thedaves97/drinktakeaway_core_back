package com.api.drinktakeaway_core_back.security;

import com.api.drinktakeaway_core_back.entity.auth.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UtentePrincipalFactory {
    public static UtentePrincipal build(Utente utente) {
        List<GrantedAuthority> authorities = utente.getRuoli().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRuoloEnum().name())).collect(Collectors.toList());
        return new UtentePrincipal(utente.getEmail(), utente.getPassword(), authorities);
    }

}
