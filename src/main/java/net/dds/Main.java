package net.dds;


import net.dds.domain.CustomerRepository;
import net.dds.domain.customer.Customer;
import net.dds.infrastructure.database.SQLCustomerRepository;

public class Main {

    public static void main(String[] args) {
        CustomerRepository customerRepository = new SQLCustomerRepository();
        Customer customer = customerRepository.findByDocumentNumber(39561928);
        customerRepository.save(customer);
    }

}