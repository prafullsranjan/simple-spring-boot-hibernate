package com.prafullranjan.code.controller;

import java.util.List;

import com.prafullranjan.code.entity.CustomerEntity;
import com.prafullranjan.code.exception.RecordNotFoundException;
import com.prafullranjan.code.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController
 *
 * @author Prafull
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity entity) {
        return new ResponseEntity<>(customerService.addCustomer(entity), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity entity) throws RecordNotFoundException {
        return new ResponseEntity<>(customerService.updateCustomer(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCustomer(@PathVariable Long id) throws RecordNotFoundException {
        customerService.deleteCustomer(id);
        return HttpStatus.FORBIDDEN;
    }
}
