package com.sennovate.service;

import com.sennovate.dto.PartnerDTO;
import com.sennovate.exceptions.ClientNotFoundException;
import com.sennovate.models.Partner;
import com.sennovate.repository.PartnerRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class MongoPartnerService implements PartnerService {
    private final PartnerRepository repository;

    public MongoPartnerService(PartnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PartnerDTO create(PartnerDTO partner) {
        repository.save(new Partner(partner.getId(),partner.getFname(),partner.getLname(),partner.getEmail()));
        return partner;
    }

    @Override
    public PartnerDTO delete(long id) {
        Partner partner = findPartnerById(id);
        repository.delete(partner);
        return convertToDTO(partner);
    }

    @Override
    public List<PartnerDTO> findAll() {
        List<Partner> partners = repository.findAll();

        return convertToDTOs(partners);
    }

    @Override
    public PartnerDTO findById(long id) {
        Partner partner = findPartnerById(id);
        return convertToDTO(partner);
    }

    @Override
    public PartnerDTO update(PartnerDTO partnerDTO) {
        Partner partner = findPartnerById(partnerDTO.getId());
        partner.setFname(partnerDTO.getFname());
        partner.setLname(partnerDTO.getLname());
        partner.setEmail(partnerDTO.getEmail());
        return convertToDTO(partner);
    }

    private Partner findPartnerById(long id){
        Optional<Partner> res = repository.findOne(id);
        return res.orElseThrow(() -> new ClientNotFoundException(id));
    }

    private List<PartnerDTO> convertToDTOs(List<Partner> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    private PartnerDTO convertToDTO(Partner model) {
        PartnerDTO dto = new PartnerDTO();

        dto.setId(model.getId());
        dto.setFname(model.getFname());
        dto.setLname(model.getLname());
        dto.setEmail(model.getEmail());

        return dto;
    }
}
