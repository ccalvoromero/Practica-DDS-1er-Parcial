package net.dds.infrastructure.inmemory;

import net.dds.domain.CustomerRepository;
import net.dds.domain.customer.Customer;

import java.util.List;
import java.util.ArrayList;

public class InMemoryCustomerRepository implements CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer findByDocumentNumber(Integer documentNumber) {
        return new Customer(documentNumber);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

}