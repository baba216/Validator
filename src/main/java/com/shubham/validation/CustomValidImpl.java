package com.shubham.validation;

import com.shubham.validation.annotations.CustomValid;
import com.shubham.validation.exception.CustomValidException;
import com.shubham.validation.response.FieldError;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.ElementKind;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class CustomValidImpl implements ConstraintValidator<CustomValid, Object> {

  private Validator validator;

  private ResponseStatus response;

  @Override
  public void initialize(CustomValid customValid) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    this.validator = factory.getValidator();
    this.response = customValid.response();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(value);
    if (!constraintViolations.isEmpty()) {
      List<FieldError> fieldErrorDTO = new ArrayList<>();
      constraintViolations.forEach(violation -> {
        Path.Node node = findLastNonEmptyPathNode(violation.getPropertyPath());
        if (node != null && node.getKind() == ElementKind.PROPERTY) {
          String fieldName = node.getName();
          String msg = violation.getMessage();
          FieldError fieldError = new FieldError(fieldName, msg);
          fieldErrorDTO.add(fieldError);
        }
      });
      throw new CustomValidException(response.name(), fieldErrorDTO);
    }
    return true;
  }

  private Path.Node findLastNonEmptyPathNode(Path path) {
    List<Path.Node> list = new ArrayList<>();
    for (Iterator<Path.Node> it = path.iterator(); it.hasNext(); ) {
      list.add(it.next());
    }
    Collections.reverse(list);
    for (Path.Node node : list) {
      if (!isEmpty(node.getName())) {
        return node;
      }
    }
    return null;
  }
}
