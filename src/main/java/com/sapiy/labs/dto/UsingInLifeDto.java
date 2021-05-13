package com.sapiy.labs.dto;

public class UsingInLifeDto {
  private Integer id;
  private String using;

  public UsingInLifeDto(Integer id, String using) {
    this.id = id;
    this.using = using;
  }

  public UsingInLifeDto(String using) {
    this.using = using;
  }

  public UsingInLifeDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsing() {
    return using;
  }

  public void setUsing(String using) {
    this.using = using;
  }
}
