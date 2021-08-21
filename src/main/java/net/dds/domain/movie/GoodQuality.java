package net.dds.domain.movie;

import net.dds.domain.customer.Customer;

public class GoodQuality implements QualityChecker {

    public void check(Customer customer) {
        customer.addRentedMovieWithoutIssue();
    }

}