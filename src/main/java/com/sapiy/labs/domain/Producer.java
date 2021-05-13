package com.sapiy.labs.domain;

import javax.persistence.*;

@Table(name = "producer")
@Entity
public class Producer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer id;

  @Column(name = "name_producer")
  public String nameProducer;

  public Producer(Integer id, String nameProducer) {
    this.id = id;
    this.nameProducer = nameProducer;
  }

  public Producer(String nameProducer) {
    this.nameProducer = nameProducer;
  }

  public Producer() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNameProducer() {
    return nameProducer;
  }

  public void setNameProducer(String nameProducer) {
    this.nameProducer = nameProducer;
  }

  @Override
  public String toString() {
    return "Producer{" +
        "id=" + id +
        ", nameProducer='" + nameProducer + '\'' +
        '}';
  }
}
