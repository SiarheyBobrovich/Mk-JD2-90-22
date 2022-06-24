package org.it_academy.spring_currency.controllers;

import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/currency")
public class CurrencyController {

    private ICRUDService service;

    public CurrencyController(@Autowired ICRUDService service) {
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
    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST)
    public long create(@RequestBody CurrencyDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/{id}")
//    @RequestMapping(method = RequestMethod.POST)
    public void update(@RequestBody Value dto, @PathVariable Long id) {
        service.update(dto, id);
    }

}