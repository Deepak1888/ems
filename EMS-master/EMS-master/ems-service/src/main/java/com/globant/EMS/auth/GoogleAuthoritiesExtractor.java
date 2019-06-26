package com.globant.EMS.auth;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.globant.EMS.dao.UserRepository;
import com.globant.EMS.model.Role;
/**
 * Modifying or overriding the default google oauth  authorities.
 * 
 * @author mayuri.shinde
 *
 */
public class GoogleAuthoritiesExtractor implements AuthoritiesExtractor {
	@Autowired
	UserRepository userRepository;
	
	
//	List<GrantedAuthority> GITHUB_SUBSCRIBED_AUTHORITIES = AuthorityUtils
//			.commaSeparatedStringToAuthorityList("GITHUB_USER,GITHUB_USER_SUBSCRIBED");

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {

//		if (Objects.nonNull(map.get("plan"))) {
//			if (!((LinkedHashMap) map.get("plan")).get("name").equals("free")) {
//				return GITHUB_SUBSCRIBED_AUTHORITIES;
//			}
//		}
//		System.out.println("in extractAuthorities---------------- ");
		List<String> roleNameList = this.getRoles((String) map.get("email"));
		
		List<GrantedAuthority> AUTHORITIES = AuthorityUtils
				.commaSeparatedStringToAuthorityList(String.join(",", roleNameList));
		return AUTHORITIES;
	}
	
	
	private List<String> getRoles(String email) {
		System.out.println("email............." + email);
		List<Role> roles=userRepository.getUserRoles(email);
		System.out.println("roles............."+roles.toString() );
		roles.forEach(System.out::print);
		List<String> roleNameList = roles.stream().map(Role::getRoleName).collect(Collectors.toList());
		System.out.println("roleNameList............." + roleNameList);
		return roleNameList;
	}
}