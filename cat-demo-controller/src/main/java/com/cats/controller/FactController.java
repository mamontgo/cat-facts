package com.cats.controller;

import com.cats.model.FactDto;
import com.cats.model.FactsDto;
import com.cats.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fact")
public class FactController {

    @Autowired
    private FactService factService;

    @GetMapping
    public FactsDto getAll() {
        return factService.findAllFacts();
    }

    @GetMapping("{uuid}")
    public FactDto getById(@PathVariable String uuid) {
        return factService.findById(uuid);
    }

}
