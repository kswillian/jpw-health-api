package com.jpwhealth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class initialController {

    @GetMapping("")
    public String olaMundo(){
        return "JPW API Online";
    }

}
