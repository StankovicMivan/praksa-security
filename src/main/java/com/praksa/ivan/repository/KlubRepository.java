package com.praksa.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praksa.ivan.model.Klub;

@Repository
public interface KlubRepository extends JpaRepository<Klub, Long>{

}
