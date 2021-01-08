package com.sennovate.service;

import com.sennovate.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO create(ClientDTO client);
    ClientDTO delete(Long id);
    List<ClientDTO> findAll();
    ClientDTO findById(Long id);
    ClientDTO update(ClientDTO client);
}
