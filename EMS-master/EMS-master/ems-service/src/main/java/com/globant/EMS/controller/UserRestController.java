/**
 * 
 */
package com.globant.EMS.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.dao.UserRepository;
import com.globant.EMS.model.Role;
import com.globant.EMS.model.User;

/**
 * @author mayuri.shinde
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserRestController {
	@Autowired
	UserRepository userService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/user")
	public Principal user(Principal principal) {
//		System.out.println("user............." + principal.getName());
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
		Authentication authentication = oAuth2Authentication.getUserAuthentication();
		Map<String, String> details = new LinkedHashMap<>();
		details = (Map<String, String>) authentication.getDetails();
		User authenticatedUser = userService.findByUserEmail(details.get("email"));
		if (authenticatedUser == null) {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("email", details.get("email"));

			User user = new User();
			user.setUsername(details.get("name"));
			user.setEmail(details.get("email"));

			Role role = new Role();
			role.setRoleId(1);
			role.setRoleName("Admin");
			role.setUser(user);
			Role role2 = new Role();
			role2.setRoleId(2);
			role2.setUser(user);
			role2.setRoleName("Employee");

			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			roles.add(role2);
			user.setRoles(roles);
			userService.save(user);
		}

		return principal;
	}
//	@RequestMapping("/roles")
//	public List<Role> roles() {
//		System.out.println("roles.............");
//		List<Role> roles=new ArrayList<Role>();
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		String auth =  (String) authentication.getPrincipal();
//		System.out.println("currentPrincipalName---" + currentPrincipalName + "auth--------" + auth);
//		roles=userRepository.getUserRoles(currentPrincipalName);
//		System.out.println("roles---" + roles);
//		return roles;
//	}

	@RequestMapping("/user/login")
	public void login() {
		System.out.println("login.............");
	}

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/users")
	public  List<User> getUsers() {
		return userService.findAll();
//		return userService.findAll().stream()
////                .filter(this::isCool)
//				.collect(Collectors.toList());
	}
	
	//@PreAuthorize("hasAuthority('Admin')")
//	@DeleteMapping("/users/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void delete(@PathVariable Integer id) {
		System.out.println("in delete");
//		userService.deleteById(id);
//		return userService.findAll().stream()
////                .filter(this::isCool)
//				.collect(Collectors.toList());
	}
	
//	@PreAuthorize("hasAuthority('Admin')")
//	@PostMapping("/user/{id}")
//	public void deleteUser(@PathVariable Integer userId) {
//		// System.out.println(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAuthorities());
//		userService.deleteById(userId);
//	}
//	
//	@PreAuthorize("hasAuthority('Admin')")
//	@DeleteMapping("/user/{id}")
//	public ResponseEntity delete(@PathVariable Integer id) {
//		if (!userService.findById(id).isPresent()) {
//			System.err.println("Id " + id + " is not existed");
//			ResponseEntity.badRequest().build();
//		}
//
//		userService.deleteById(id);
//
//		return ResponseEntity.ok().build();
//	}



	@GetMapping("/user/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			System.err.println("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(user.get());
	}

	

}
