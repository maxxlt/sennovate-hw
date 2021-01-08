package com.sennovate.repository;


import com.sennovate.models.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartnerRepository extends MongoRepository<Partner, Long> {

}
