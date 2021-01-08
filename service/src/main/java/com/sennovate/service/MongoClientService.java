package com.sennovate.service;

import com.sennovate.dto.ClientDTO;
import com.sennovate.exceptions.ClientNotFoundException;
import com.sennovate.models.Client;
import com.sennovate.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class MongoClientService implements ClientService {
    private final ClientRepository repository;

    @Autowired
    public MongoClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        repository.save(new Client(clientDTO.getId(),clientDTO.getFname(),clientDTO.getLname(),clientDTO.getEmail()));
        return clientDTO;
    }

    @Override
    public ClientDTO delete(Long id) {
        Client client = findClientById(id);
        repository.delete(client);
        return convertToDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> client = repository.findAll();
        return convertToDTOs(client);
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = findClientById(id);
        return convertToDTO(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        Client client = findClientById(clientDTO.getId());
        client.setFname(clientDTO.getFname());
        client.setLname(clientDTO.getLname());
        client.setEmail(clientDTO.getEmail());
        return convertToDTO(client);
    }

    private List<ClientDTO> convertToDTOs(List<Client> clients) {
        return clients.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    private Client findClientById(long id){
        Optional<Client> res = repository.findOne(id);
        return res.orElseThrow(() -> new ClientNotFoundException(id));
    }

    private ClientDTO convertToDTO(Client model) {
        ClientDTO dto = new ClientDTO();

        dto.setId(model.getId());
        dto.setFname(model.getFname());
        dto.setLname(model.getLname());
        dto.setEmail(model.getEmail());

        return dto;
    }
}
