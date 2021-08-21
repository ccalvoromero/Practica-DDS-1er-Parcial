package net.dds.domain.movie;

import net.dds.domain.customer.Customer;

public class BadQuality implements QualityChecker {

    public void check(Customer customer) {
        customer.addMovieIssue();
        customer.resetRentedMoviesWithoutIssues();
    }

}
