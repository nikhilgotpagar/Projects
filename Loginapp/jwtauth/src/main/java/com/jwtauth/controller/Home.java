package com.jwtauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/home")
    public String Welcome(){
        String text ="This is a private page";
        text += "Not allowed to unauthenticated users";
        return text;
    }
}
