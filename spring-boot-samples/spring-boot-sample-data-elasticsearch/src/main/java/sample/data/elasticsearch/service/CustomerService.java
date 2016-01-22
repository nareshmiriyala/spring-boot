package sample.data.elasticsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.data.elasticsearch.Customer;
import sample.data.elasticsearch.CustomerRepository;

/**
 * Created by nmiriyal on 22/01/2016.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void saveCustomer(Customer customer){
        repository.save(customer);
    }
}
