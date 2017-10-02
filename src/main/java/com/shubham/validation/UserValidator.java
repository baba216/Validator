package com.shubham.validation;

import com.shubham.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return User.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
    User user = (User) target;
    if(StringUtils.isEmpty(user.getName())){
      errors.rejectValue("name", "289", "name cannot be empty");
    }else if(user.getEmail().contains("coviam")){
      errors.rejectValue("email","231","not found");
    }
  }
}
