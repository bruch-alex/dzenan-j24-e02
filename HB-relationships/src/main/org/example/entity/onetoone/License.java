package org.example.entity.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "licenses")
public class License {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  public License() {}

  public License(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "License{" +
        "id=" + id +
        ", description='" + description + '\'' +
        '}';
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
