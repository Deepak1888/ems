/**
 * 
 */
package com.globant.EMS.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.model.Role;

/**
 * @author mayuri.shinde
 *
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAuthority('Admin')")
public class AdminController {
	@RequestMapping("/admin")
	public Role admin(HttpServletRequest request) {
//		request.isUserInRole("someAuthority");
		System.out.println("ADMIN............."+hasRole("ROLE_ADMIN")+ " "+request.isUserInRole("ADMIN"));
		Role r=new Role();
		r.setRoleId(55);
		return r;
	}
	
	private boolean hasRole(String role) {
		  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
		  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
			 System.out.println("authority----"+authority.getAuthority());
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		} 
}
