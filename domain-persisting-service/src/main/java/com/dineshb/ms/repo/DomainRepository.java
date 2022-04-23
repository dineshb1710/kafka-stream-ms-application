package com.dineshb.ms.repo;

import com.dineshb.ms.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {
    // Custom methods goes here..
}
