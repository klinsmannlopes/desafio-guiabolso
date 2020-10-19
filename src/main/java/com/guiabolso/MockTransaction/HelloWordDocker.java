package com.guiabolso.MockTransaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloWordDocker {

    @GetMapping("/")
    public String hello() {
        return "hello menino ney";
    }

}
