package com.shubham.service;

import com.shubham.entity.Customer;
import com.shubham.model.CustomerDTO;
import com.shubham.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.Timestamp;

@Slf4j
@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public CustomerDTO saveCustomer(CustomerDTO customerDTO){
    log.info("Going to save customer:{}",customerDTO);
    Customer customer = new Customer();
    customer.setName(customerDTO.getName());
    customer.setStatus(customerDTO.getStatus());
    customer.setCreatedOn(new Timestamp(System.currentTimeMillis()));
    customerRepository.save(customer);
    customerDTO.setId(customer.getId());
    return customerDTO;
  }

  public CustomerDTO getCustomer(Integer id){
    log.info("Getting customer for id:{}",id);
    Customer customer = customerRepository.getOne(id);
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setId(customer.getId());
    customerDTO.setName(customer.getName());
    customerDTO.setStatus(customer.getStatus());
    return customerDTO;
  }
}
