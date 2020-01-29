package com.iga.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.iga.helpdesk.api.security.entity.User;
import com.iga.helpdesk.api.security.enums.ProfileEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {		
	}
	
	// Esse método converte/gera um JwtUser com base nos dados de um usuário 
	public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getProfile())
        );
    }

	// Esse método converte um perfil do usuário para um formato utilizado pelo spring security
	 private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
 		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
 		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
 		return   authorities ;
 }

}
