package com.shubham;

import com.shubham.model.CustomerDTO;
import com.shubham.validation.group.UpdateCustomerValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CustomerTest {

  /*private static Validator validator;

  @BeforeClass
  public static void setupValidator(){
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  public void customerNameIsNull() {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setStatus("ACTIVE");
    Set<ConstraintViolation<CustomerDTO>> constraintViolations = validator.validate(customerDTO);
    Assert.assertEquals(1, constraintViolations.size());
    Assert.assertEquals("CUSTOMER_NAME_CANNOT_BE_EMPTY",
        constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void customerStatusIsNull() {
    CustomerDTO customerDTO = new CustomerDTO();
    //customerDTO.setName("ACTIVE");
    Set<ConstraintViolation<CustomerDTO>> constraintViolations = validator.validate(customerDTO,
        UpdateCustomerValidator.class);
    Assert.assertEquals(1, constraintViolations.size());
    Assert.assertEquals("CUSTOMER_STATUS_CANNOT_BE_NULL",
        constraintViolations.iterator().next().getMessage());
  }*/

}
