package com.sennovate.controller;

import com.sennovate.dto.PartnerDTO;
import com.sennovate.exceptions.ClientNotFoundException;
import com.sennovate.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    private final PartnerService service;

    @Autowired
    public PartnerController(PartnerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    PartnerDTO create(@RequestBody @Validated PartnerDTO partnerDTO){
        return service.create(partnerDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    PartnerDTO delete(@PathVariable("id") long id){
        return service.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    PartnerDTO findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    PartnerDTO update(@RequestBody @Validated PartnerDTO partnerDTO){
        return service.update(partnerDTO);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleClientNotFound(ClientNotFoundException e){
        System.out.println("Error message: " + e.getMessage());
    }
}
