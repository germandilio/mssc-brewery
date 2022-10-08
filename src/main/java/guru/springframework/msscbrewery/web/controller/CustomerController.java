package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.Customer;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }


  @GetMapping("/{customerId}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") UUID id) {
    return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<HttpHeaders> createCustomer(@RequestBody Customer customer) {
    var newCustomer = customerService.createCustomer(customer);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer" + newCustomer.getId());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<Void> handleUpdate(@PathVariable("customerId") UUID id, @RequestBody Customer customer) {
    customerService.updateCustomer(id, customer);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<Void> handleDelete(@PathVariable("customerId") UUID id) {
    customerService.deleteCustomer(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
