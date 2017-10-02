package com.shubham.validation.annotations;


import com.shubham.validation.ResponseStatus;
import com.shubham.validation.CheckCaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
@Repeatable(CustomValid.List.class)
public @interface CustomValid {

  String message() default "{org.hibernate.validation.referenceguide.chapter06.CheckCase."
      + "message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  ResponseStatus response();

  @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
  @Retention(RUNTIME)
  @Documented
  @interface List {
    CustomValid[] value();
  }
}
