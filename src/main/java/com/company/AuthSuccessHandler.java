package com.company;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,   HttpServletResponse response, Authentication authentication) throws IOException  {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("admin");
        } else if (roles.contains("ROLE_PATIENT")) {
            response.sendRedirect("patient");
        }  else if (roles.contains("ROLE_LABWORKER")) {
            response.sendRedirect("user");
        } else if (roles.contains("ROLE_CLINICWORKER")) {
            response.sendRedirect("clinic-worker");
        } else if (roles.contains("ROLE_DOCTOR")) {
            response.sendRedirect("user");
        }
    }
}
