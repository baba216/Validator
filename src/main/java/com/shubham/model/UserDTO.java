package com.shubham.model;

import com.shubham.validation.annotations.CheckCase;
import com.shubham.validation.CaseMode;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

  @NotNull
  @CheckCase(value = CaseMode.UPPER,message = "NAME SHOULD BE IN CAPS")
  private String name;


}
