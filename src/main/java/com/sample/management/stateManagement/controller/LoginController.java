package com.sample.management.stateManagement.controller;

import com.sample.management.stateManagement.domain.entity.dto.LoginUser;
import com.sample.management.stateManagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/loginAction")
    public ResponseEntity<HashMap> greetingSubmit(LoginUser user) {
        HashMap result = null;
        try{
            result = loginService.checkExists(user);
        }catch (Exception e){
            result = new HashMap();
            result.put("result", false);
            result.put("error", e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

}
