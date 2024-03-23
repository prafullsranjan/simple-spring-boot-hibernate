package com.prafullranjan.code.repository;

import com.prafullranjan.code.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 *
 * @author Prafull
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
