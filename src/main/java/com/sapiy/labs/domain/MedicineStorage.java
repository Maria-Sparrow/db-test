package com.sapiy.labs.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "medicine_storage")
@Entity
public class MedicineStorage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToMany(mappedBy = "medicineStorage", fetch = FetchType.EAGER)
  private Set<Medicine> medicines;

  public MedicineStorage(Integer id, Set<Medicine> medicines) {
    this.id = id;
    this.medicines = medicines;
  }

  public MedicineStorage(Set<Medicine> medicines) {
    this.medicines = medicines;
  }

  public MedicineStorage() {

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
    return "MedicineStorage{" +
        "id=" + id +
        '}';
  }
}
