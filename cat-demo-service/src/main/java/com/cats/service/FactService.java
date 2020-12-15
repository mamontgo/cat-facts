package com.cats.service;

import com.cats.model.FactDto;
import com.cats.model.FactsDto;

import java.util.List;

public interface FactService {
    FactDto findById(String uuid);

    List<FactDto> findAll();

    FactsDto findAllFacts();
}
