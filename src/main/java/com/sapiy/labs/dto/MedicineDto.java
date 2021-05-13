package com.sapiy.labs.dto;

public class MedicineDto {
  private Integer id;
  private String name;
  private String price;

  public MedicineDto(Integer id, String name, String price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public MedicineDto() {
  }

  public MedicineDto(String name, String price) {
    this.name = name;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
