package org.it_academy.spring_currency.controllers;

import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final ICRUDService service;

    public CurrencyController(ICRUDService service) {
        this.service = service;
    }

    @GetMapping
    public List<Value> getList() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Value get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    public long create(@RequestBody CurrencyDto dto) {
        return service.save(dto);
    }
}