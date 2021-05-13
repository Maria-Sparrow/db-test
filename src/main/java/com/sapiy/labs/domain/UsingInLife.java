package com.sapiy.labs.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "using_in_life")
@Entity
public class UsingInLife {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToMany(mappedBy = "usingInLife", fetch = FetchType.EAGER)
  private Set<Medicine> medicines;

  public UsingInLife(int id, Set<Medicine> medicines) {
    this.id = id;
    this.medicines = medicines;
  }

  public UsingInLife() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<Medicine> getMedicines() {
    return medicines;
  }

  public void setMedicines(Set<Medicine> medicines) {
    this.medicines = medicines;
  }

  @Override
  public String toString() {
    return "UsingInLife{" +
        "id=" + id +
        '}';
  }
}
