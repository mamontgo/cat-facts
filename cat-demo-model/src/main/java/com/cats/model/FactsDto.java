package com.cats.model;

import java.util.ArrayList;
import java.util.List;

public class FactsDto {

    private List<FactDto> all;

    public FactsDto() {
        this.all = new ArrayList<>();
    }

    public FactsDto(List<FactDto> all) {
        this.all = all;
    }

    public List<FactDto> getAll() {
        return all;
    }

    public void setAll(List<FactDto> all) {
        this.all = all;
    }
}
