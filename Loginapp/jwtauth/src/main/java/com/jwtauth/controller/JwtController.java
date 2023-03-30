package com.jwtauth.controller;

import com.jwtauth.helper.JwtUtil;
import com.jwtauth.model.JwtRequest;
import com.jwtauth.model.JwtResponse;
import com.jwtauth.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws  Exception{
        System.out.println(jwtRequest);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassowrd()));
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new BadCredentialsException("Bad Creds");
        }

        //fine area

        UserDetails userDetails =  this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());

       String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT"+ token);

        //{"token" : "value"}

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
