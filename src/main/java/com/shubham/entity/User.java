package com.shubham.entity;

import com.shubham.validation.annotations.CheckCase;
import com.shubham.validation.CaseMode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Setter
@Getter
@Slf4j
public class User {

  @NotEmpty
  @CheckCase(value = CaseMode.UPPER,message = "NAME SHOULD BE IN CAPS")
  private String name;
  @Email
  private String email;

  private Date dob;

}
