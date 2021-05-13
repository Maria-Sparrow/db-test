package com.sapiy.labs.dto;

public class TypeOfPackingDto {
  private Integer id;
  private String typeOfPacking;

  public TypeOfPackingDto(Integer id, String typeOfPacking) {
    this.id = id;
    this.typeOfPacking = typeOfPacking;
  }

  public TypeOfPackingDto(String typeOfPacking) {
    this.typeOfPacking = typeOfPacking;
  }

  public TypeOfPackingDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTypeOfPacking() {
    return typeOfPacking;
  }

  public void setTypeOfPacking(String typeOfPacking) {
    this.typeOfPacking = typeOfPacking;
  }
}
