
package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
//
//    @GetMapping("/")
//    public String home(){
//        return("index");
//    }

    @GetMapping("/user")
    public String user(){
        return("<h1>Usr home</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Adm home</h1>");
    }
}