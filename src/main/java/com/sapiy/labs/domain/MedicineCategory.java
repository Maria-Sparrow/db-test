package com.sapiy.labs.domain;


import javax.persistence.*;
import java.util.Set;

@Table(name = "medicine_categories")
@Entity
public class MedicineCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public int id;

  @OneToMany(mappedBy = "medicineCategory", fetch = FetchType.EAGER)
  private Set<Medicine> medicines;

  public MedicineCategory(int id, Set<Medicine> medicines) {
    this.id = id;
    this.medicines = medicines;

  }

  public MedicineCategory() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMedicine(Set<Medicine> medicines) {
    this.medicines = medicines;
  }

  public Set<Medicine> getMedicine() {
    return medicines;
  }

  @Override
  public String toString() {
    return "MedicineCategories{" +
        "id=" + id +
        '}';
  }

}
