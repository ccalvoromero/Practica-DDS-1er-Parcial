package net.dds.domain;

import net.dds.domain.customer.Customer;

public interface CustomerRepository {
    Customer findByDocumentNumber(Long documentNumber);
    void save(Customer customer);
}