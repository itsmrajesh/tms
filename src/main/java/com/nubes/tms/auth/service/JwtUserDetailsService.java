package com.nubes.tms.auth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.domain.Role;
import com.nubes.tms.repo.AppUserRepo;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AppUserRepo userRepository;

	

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public AppUser findByUsername(String username) {
	    return userRepository.findByUsername(username);
	}
	
	public void saveUser(AppUser user) {
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username){
	
	    AppUser user = userRepository.findByEmail(username);
	    if(user != null) {
	        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	        return buildUserForAuthentication(user, authorities);
	    } else {
	        throw new UsernameNotFoundException("Username not found");
	    }
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach(role -> roles.add(new SimpleGrantedAuthority(role.getRole())));
        return new ArrayList<>(roles);
	}
	
	private UserDetails buildUserForAuthentication(AppUser user, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}