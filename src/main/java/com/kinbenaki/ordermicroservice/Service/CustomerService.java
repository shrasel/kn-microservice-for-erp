package com.kinbenaki.ordermicroservice.Service;

import com.kinbenaki.ordermicroservice.Exception.ProductNotFoundException;
import com.kinbenaki.ordermicroservice.Model.Customer;
import com.kinbenaki.ordermicroservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setFirstName(updatedCustomer.getFirstName());

            return customerRepository.save(existingCustomer);
        } else {
            // Handle case where product with given ID is not found
            throw new ProductNotFoundException("Product not found with ID: " + customerId);
        }
    }


    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
