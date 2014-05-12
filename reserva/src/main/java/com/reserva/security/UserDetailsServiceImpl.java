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
import com.reserva.dao.SeguridadDAO;
import com.reserva.model.Empleado;
import com.reserva.model.EmpleadoPermiso;

@Service("UserDetailServiceImpl")
@Transactional(readOnly=true) 
public class UserDetailsServiceImpl implements UserDetailsService{
	
	// just to emulate user data and credentials retrieval from a DB, or whatsoever authentication service
	private static Map<String, UserDetails> userRepository = new HashMap<String, UserDetails>();
	
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	private SeguridadDAO seguridadDAO;
	
	/*static{
		GrantedAuthority authorityAdmin = new GrantedAuthorityImpl("ADMIN");
		GrantedAuthority authorityGuest = new GrantedAuthorityImpl("GUEST");
		GrantedAuthority authorityAdministrador = new GrantedAuthorityImpl("ADMINISTRADOR");
		
		 user1/password1 --> ADMIN 
		Set<GrantedAuthority> authorities1 = new HashSet<GrantedAuthority>();
		authorities1.add(authorityAdmin);
		UserDetails user1 = new UserDetailsImpl("user1", "user1", authorities1);
		userRepository.put("user1", user1);
		
		 user2/password2 --> GUEST 
		Set<GrantedAuthority> authorities2 = new HashSet<GrantedAuthority>();
		authorities2.add(authorityGuest);
		UserDetails user2 = new UserDetailsImpl("user2", "user2", authorities2);
		userRepository.put("user2", user2);
		
		 user3/password3 --> ADMIN + GUEST 
		Set<GrantedAuthority> authorities3 = new HashSet<GrantedAuthority>();
		authorities3.add(authorityAdmin);
		authorities3.add(authorityGuest);
		authorities3.add(authorityAdministrador);
		UserDetails user3 = new UserDetailsImpl("user3", "user3", authorities3);
		userRepository.put("user3", user3);			
		
	}*/
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		GrantedAuthority authorityIngreso = new GrantedAuthorityImpl("INGRESO");

		Set<GrantedAuthority> listaPermisos = new HashSet<GrantedAuthority>();//lista de permisos
		listaPermisos.add(authorityIngreso);

		List<Empleado> lista =  empleadoDAO.getEmpleados();//consulta todos los empleados
		for (Empleado empleado : lista) {
			
			List<EmpleadoPermiso> listaPermiso = seguridadDAO.getEmpleadoPermiso(empleado.getId());//consulta los permisos
			for (EmpleadoPermiso empleadoPermiso : listaPermiso) {
				if(empleadoPermiso.getEmpleado_Id().getId() == empleado.getId() && empleado.getUsuario().equals(username) ){//valida que exista el empleado
					GrantedAuthority permisoConfigurado = new GrantedAuthorityImpl(empleadoPermiso.getPermiso_Id().getNombre());
					listaPermisos.add(permisoConfigurado);				
				}
			} 			
			
			UserDetails user = new UserDetailsImpl(empleado.getUsuario(), empleado.getContrasena(), listaPermisos);				
			userRepository.put(empleado.getUsuario(), user);//adicion de permisos			
		}
		
		
		UserDetails matchingUser = userRepository.get(username);//se consulta el usuario
		
		if(matchingUser == null){
			throw new UsernameNotFoundException("Wrong username or password");
		}
		
		return matchingUser;
	}

}
