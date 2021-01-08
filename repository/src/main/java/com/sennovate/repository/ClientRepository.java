package com.sennovate.repository;


import com.sennovate.models.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Qualifier("client")
@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {
    void delete(Client client);
    List<Client> findAll();
    Optional<Client> findOne(long id);
    Client save(Client client);
}
