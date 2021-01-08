package com.sennovate.controller;

import com.sennovate.dto.ClientDTO;
import com.sennovate.exceptions.ClientNotFoundException;
import com.sennovate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ClientDTO create(@RequestBody @Validated ClientDTO clientDTO){
        return service.create(clientDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ClientDTO delete(@PathVariable("id") long id){
        return service.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ClientDTO findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ClientDTO update(@RequestBody @Validated ClientDTO clientDTO){
        return service.update(clientDTO);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleClientNotFound(ClientNotFoundException e){
        System.out.println("Error message: " + e.getMessage());
    }
}
