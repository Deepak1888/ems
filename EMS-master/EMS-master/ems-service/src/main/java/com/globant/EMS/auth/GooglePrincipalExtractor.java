/**
 * 
 */
package com.globant.EMS.auth;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

/**
 * @author mayuri.shinde
 *
 */
public class GooglePrincipalExtractor  implements PrincipalExtractor {
 
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        return map.get("login");
    }
}