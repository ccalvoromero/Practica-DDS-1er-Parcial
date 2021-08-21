package net.dds.domain.movie;

import net.dds.domain.customer.Customer;

public interface QualityChecker {
    void check(Customer customer);
}
