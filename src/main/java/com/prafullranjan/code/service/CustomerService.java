package com.prafullranjan.code.service;

import java.util.ArrayList;
import java.util.List;

import com.prafullranjan.code.entity.CustomerEntity;
import com.prafullranjan.code.entity.Property;
import com.prafullranjan.code.exception.RecordNotFoundException;
import com.prafullranjan.code.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * CustomerService
 *
 * @author Prafull
 */
@Service
public class CustomerService {

    @Value("${spring.datasource.url}")
    private String value;

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll().isEmpty() ? new ArrayList<>() : customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException {
        try {
            return customerRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        } catch (RecordNotFoundException ex) {
            throw new RecordNotFoundException(id + " not found");
        }
    }

    public CustomerEntity addCustomer(CustomerEntity entity) {
        return customerRepository.save(entity);
    }

    public CustomerEntity updateCustomer(Long id, CustomerEntity entity) throws RecordNotFoundException {
        if (customerRepository.findById(id).isPresent()) {
            CustomerEntity customer = new CustomerEntity();
            customer.setId(id);
            customer.setName(entity.getName());
            customer.setEmail(entity.getEmail());
            customer.setCity(entity.getCity());
            return customerRepository.save(customer);
        } else throw new RecordNotFoundException(id + " not found");
    }

    public void deleteCustomer(Long id) throws RecordNotFoundException {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        } else throw new RecordNotFoundException(id + " not found");
    }

    public void getSystemValues() {
        System.out.println("Value: " + value);
        System.out.println("M2_HOME: " + Property.m2Home);
    }
}
