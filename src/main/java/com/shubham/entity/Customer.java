package com.shubham.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "CREATED_ON")
  private Timestamp createdOn;

  @Column(name = "CREATED_BY")
  private Timestamp createdBy;

  @Column(name = "UPDATED_ON")
  private Timestamp updatedOn;

  @Column(name = "UPDATED_BY")
  private Timestamp updatedBy;
}
