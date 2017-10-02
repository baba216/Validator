package com.shubham.validation.exception;

import com.shubham.validation.response.FieldError;

import java.util.List;

public class CustomValidException extends RuntimeException {

  private static final long serialVersionUID = 935664450342828653L;

  private List<FieldError>  errors ;

  public CustomValidException(String message, List<FieldError> errors) {
    super(message);
    this.errors = errors;
  }
}
