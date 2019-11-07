package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.CountryMaster;

@Repository
public interface CountryRepository extends JpaRepository<CountryMaster, Integer> {

}
