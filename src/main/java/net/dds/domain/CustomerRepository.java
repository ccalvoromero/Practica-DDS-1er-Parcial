package net.dds.domain;

import net.dds.domain.customer.Customer;

public interface CustomerRepository {
    Customer findByDocumentNumber(Integer documentNumber);
    void save(Customer customer);
}