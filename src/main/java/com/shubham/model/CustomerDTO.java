package com.shubham.model;

import com.shubham.entity.User;
import com.shubham.validation.group.UpdateCustomerValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Data
public class CustomerDTO {

  private Integer id;

  @Size(min = 4,max = 10, message = "CUSTOMER NAME HAS TO BE GREATER THAN 10")
  private String name;


  @NotEmpty(groups = {UpdateCustomerValidator.class},message = "CUSTOMER_STATUS_CANNOT_BE_NULL")
  @Size(min = 3,max = 10)
  private String status;

  @Valid
  private User createdBy;

  @Future(message = "The value '${formatter.format('%1$tY-%1$tm-%1$td', validatedValue)}' is not in future!")
  private Timestamp expiresAt;

  @Size(max = 2)
  @Valid
  private List<User> userList;

}
