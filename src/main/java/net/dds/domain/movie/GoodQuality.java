package net.dds.domain.movie;

import net.dds.domain.customer.Customer;

public class GoodQuality implements StrategyIssues {

    public void execute(Customer customer) {
        customer.addRentedMovieWithoutIssue();

    }
}
