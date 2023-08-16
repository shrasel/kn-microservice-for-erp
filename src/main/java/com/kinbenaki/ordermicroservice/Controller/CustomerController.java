package com.kinbenaki.ordermicroservice.Controller;

import com.kinbenaki.ordermicroservice.Model.Customer;
import com.kinbenaki.ordermicroservice.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long customerId,
            @Valid @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(customerId);

        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }

        Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
