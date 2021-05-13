package com.sapiy.labs.dto;

public class MedicineStorageDto {
  private Integer id;
  private String storage;

  public MedicineStorageDto(Integer id, String storage) {
    this.id = id;
    this.storage = storage;
  }

  public MedicineStorageDto(String storage) {
    this.storage = storage;
  }

  public MedicineStorageDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }
}

