package com.shubham.controller;

import com.shubham.model.CustomerDTO;
import com.shubham.service.CustomerService;
import com.shubham.validation.ResponseStatus;
import com.shubham.validation.annotations.CustomValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Slf4j
@RestController
@Validated
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
  public ResponseEntity<CustomerDTO> getCustomer(
      @PathVariable("id") @Min(value = 10, message = "Buh Yaa") Long id) {
    log.info("Getting customer for id:{}", id);
    CustomerDTO readCustomer = customerService.getCustomer(id.intValue());
    return new ResponseEntity<>(readCustomer, HttpStatus.OK);
  }

  @RequestMapping(value = "customer", method = RequestMethod.POST)
  public ResponseEntity<CustomerDTO> postCustomer(@RequestBody @CustomValid(response = ResponseStatus.JOB) CustomerDTO customerDTO) {
    log.info("Going to create customer:{}",customerDTO);
    CustomerDTO saveCustomer = customerService.saveCustomer(customerDTO);
    return new ResponseEntity<>(saveCustomer, HttpStatus.OK);
  }

  /*@ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorsDTO> processValidationError(MethodArgumentNotValidException e){
    BindingResult bindingResult = e.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    log.info("Working");
    ValidationErrorsDTO validationErrorsDTO = new ValidationErrorsDTO();
    fieldErrors.forEach(fieldError -> {
      String message = fieldError.getDefaultMessage();
      String field = fieldError.getField();
      validationErrorsDTO.addFieldErrorObject(field,message);
    });
    return new ResponseEntity<>(validationErrorsDTO,HttpStatus.BAD_REQUEST);
  }*/

}
