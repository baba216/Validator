package com.shubham.validation;

import com.shubham.validation.annotations.CheckCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

  private CaseMode caseMode;

  @Override
  public void initialize(CheckCase constraintAnnotation) {
      this.caseMode = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if(value==null){
      return true;
    }
    if(caseMode == CaseMode.UPPER){
      return value.equals(value.toUpperCase());
    }else {
      return value.equals(value.toLowerCase());
    }
  }
}
