package org.example.entity.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String number;

//  @ManyToOne
//  private Customer customer;

  public PhoneNumber() {}

  public PhoneNumber(String number) {
    this.number = number;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

//  public Customer getCustomer() {
//    return customer;
//  }
//
//  public void setCustomer(Customer customer) {
//    this.customer = customer;
//  }
}
