package com.sennovate.repository;


import com.sennovate.models.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends MongoRepository<Partner, Long> {
    void delete(Partner partner);
    List<Partner> findAll();
    Optional<Partner> findOne(long id);
    Partner save(Partner partner);
}
