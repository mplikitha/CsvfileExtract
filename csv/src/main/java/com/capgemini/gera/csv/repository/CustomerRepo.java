package com.capgemini.gera.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gera.csv.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
