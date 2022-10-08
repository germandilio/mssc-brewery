package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.Customer;
import java.util.UUID;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
  private static final Logger log = Logger.getLogger(CustomerServiceImpl.class);

  @Override
  public Customer getCustomer(UUID customerId) {
    return Customer.builder()
        .id(customerId)
        .name("Mega Customer")
        .build();
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return Customer.builder()
        .id(UUID.randomUUID())
        .name(customer.getName())
        .build();
  }

  @Override
  public Customer updateCustomer(UUID id, Customer customer) {
    return Customer.builder()
        .id(id)
        .name(customer.getName())
        .build();
  }

  @Override
  public void deleteCustomer(UUID id) {
    log.debug("Delete customer with UUID: " + id);
  }
}
