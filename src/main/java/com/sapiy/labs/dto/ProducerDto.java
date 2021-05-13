package com.sapiy.labs.dto;

public class ProducerDto {
  private Integer id;
  private String producerName;

  public ProducerDto(Integer id, String producerName) {
    this.id = id;
    this.producerName = producerName;
  }

  public ProducerDto(String producerName) {
    this.producerName = producerName;
  }

  public ProducerDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProducerName() {
    return producerName;
  }

  public void setProducerName(String producerName) {
    this.producerName = producerName;
  }
}


