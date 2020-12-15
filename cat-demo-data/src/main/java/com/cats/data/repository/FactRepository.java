package com.cats.data.repository;

import com.cats.data.entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<Fact, String> {
}
