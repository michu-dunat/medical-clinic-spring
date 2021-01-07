package com.company.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String redirectLogin(Model model) {
        return "index";
    }

    @RequestMapping("/home")
    public String redirectHome() {
        Authentication getCurrentLoginContext = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = AuthorityUtils.authorityListToSet(getCurrentLoginContext.getAuthorities());
        if (roles.contains("ROLE_PATIENT")) {
            return "redirect:/patient";
        } else if (roles.contains("ROLE_CLINICWORKER")) {
            return "redirect:/clinic-worker";
        }
        return "redirect:/";
    }
}
