package net.dds.domain;

import net.dds.domain.client.Customer;

public interface ClientRepository {
    Customer findById(Long id);
    void update(Customer client);
}