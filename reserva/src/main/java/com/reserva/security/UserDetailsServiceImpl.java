package com.reserva.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserva.dao.EmpleadoDAO;
import com.reserva.model.Empleado;

@Service("UserDetailServiceImpl")
@Transactional(readOnly=true) 
public class UserDetailsServiceImpl implements UserDetailsService{
	
	// just to emulate user data and credentials retrieval from a DB, or whatsoever authentication service
	private static Map<String, UserDetails> userRepository = new HashMap<String, UserDetails>();
	
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	static{
		GrantedAuthority authorityAdmin = new GrantedAuthorityImpl("ADMIN");
		GrantedAuthority authorityGuest = new GrantedAuthorityImpl("GUEST");
		GrantedAuthority authorityAdministrador = new GrantedAuthorityImpl("ADMINISTRADOR");
		
		/* user1/password1 --> ADMIN */
		Set<GrantedAuthority> authorities1 = new HashSet<GrantedAuthority>();
		authorities1.add(authorityAdmin);
		UserDetails user1 = new UserDetailsImpl("user1", "user1", authorities1);
		userRepository.put("user1", user1);
		
		/* user2/password2 --> GUEST */
		Set<GrantedAuthority> authorities2 = new HashSet<GrantedAuthority>();
		authorities2.add(authorityGuest);
		UserDetails user2 = new UserDetailsImpl("user2", "user2", authorities2);
		userRepository.put("user2", user2);
		
		/* user3/password3 --> ADMIN + GUEST */
		Set<GrantedAuthority> authorities3 = new HashSet<GrantedAuthority>();
		authorities3.add(authorityAdmin);
		authorities3.add(authorityGuest);
		authorities3.add(authorityAdministrador);
		UserDetails user3 = new UserDetailsImpl("user3", "user3", authorities3);
		userRepository.put("user3", user3);			
		
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		GrantedAuthority authorityAdmin = new GrantedAuthorityImpl("ADMIN");

		Set<GrantedAuthority> authorities3 = new HashSet<GrantedAuthority>();
		authorities3.add(authorityAdmin);

		List<Empleado> lista =  empleadoDAO.getEmpleados();
		for (Empleado empleado : lista) {
			UserDetails user = new UserDetailsImpl(empleado.getUsuario(), empleado.getContrasena(), authorities3);			
			userRepository.put(empleado.getUsuario(), user);			
		}
		
		
		UserDetails matchingUser = userRepository.get(username);
		
		if(matchingUser == null){
			throw new UsernameNotFoundException("Wrong username or password");
		}
		
		return matchingUser;
	}

}
