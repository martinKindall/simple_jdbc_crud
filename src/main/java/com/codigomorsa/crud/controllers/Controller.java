package com.codigomorsa.crud.controllers;

import com.codigomorsa.crud.model.Os;
import com.codigomorsa.crud.services.OsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final OsService osService;

    public Controller(OsService osService) {
        this.osService = osService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hi there";
    }

    @GetMapping("/os")
    public List<Os> getAllOs() {
        return osService.getAllOs();
    }

    @PostMapping("/os")
    public long createOs(@RequestBody Os newOs) {
        return osService.createOs(newOs);
    }
}
