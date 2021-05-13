package com.sapiy.labs.domain;

import javax.persistence.*;

@Table(name = "type_of_packing")
@Entity
public class TypeOfPacking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "type")
  public String type;

  public TypeOfPacking(Integer id, String type) {
    this.id = id;
    this.type = type;
  }

  public TypeOfPacking() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "TypeOfPacking{" +
        "id=" + id +
        ", type='" + type + '\'' +
        '}';
  }
}
