package com.sapiy.labs.dto;

public class MedicineCategoryDto {
  private Integer id;
  private String category;

  public MedicineCategoryDto(Integer id, String category) {
    this.id = id;
    this.category = category;
  }

  public MedicineCategoryDto(String category) {
    this.category = category;
  }

  public MedicineCategoryDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
