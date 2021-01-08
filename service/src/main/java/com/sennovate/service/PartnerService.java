package com.sennovate.service;

import com.sennovate.dto.PartnerDTO;

import java.util.List;

public interface PartnerService {
    PartnerDTO create(PartnerDTO partner);
    PartnerDTO delete(long id);

    List<PartnerDTO> findAll();

    PartnerDTO findById(long id);

    PartnerDTO update(PartnerDTO partner);
}
