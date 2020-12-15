package com.cats.service.impl;

import com.cats.data.entity.Fact;
import com.cats.data.repository.FactRepository;
import com.cats.model.FactDto;
import com.cats.model.FactsDto;
import com.cats.service.FactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactServiceImpl implements FactService {

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private FactRepository repository;

    @Override
    public FactDto findById(String uuid) {
        return map(repository.getOne(uuid));
    }

    @Override
    public List<FactDto> findAll() {
        return repository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public FactsDto findAllFacts() {
        return new FactsDto(findAll());
    }

    private FactDto map(Fact fact) {
        if (fact != null) {
            return mapper.map(fact, FactDto.class);
        }
        return null;
    }
}
