package net.dds.domain.movie;

import net.dds.domain.customer.Customer;

public class BadQuality implements StrategyIssues {

    public void execute(Customer customer) {
                customer.addIssue();
                customer.resetRentedMoviesWithoutIssues();
    }

}
