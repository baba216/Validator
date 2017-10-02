package com.shubham.validation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class FieldError {

  @JsonProperty("requestField")
  private String field;

  @JsonProperty("error")
  private String message;
}
