package com.sennovate.repository;


import com.sennovate.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, Long> {
    void delete(Client client);
    List<Client> findAll();
    Optional<Client> findOne(long id);
    Client save(Client client);
}
