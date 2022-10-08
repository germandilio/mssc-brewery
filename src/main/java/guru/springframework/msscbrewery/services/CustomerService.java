package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.Customer;
import java.util.UUID;

public interface CustomerService {
  Customer getCustomer(UUID id);

  Customer createCustomer(Customer customer);

  Customer updateCustomer(UUID id, Customer customer);

  void deleteCustomer(UUID id);
}
