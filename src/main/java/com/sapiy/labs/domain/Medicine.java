package com.sapiy.labs.domain;

import javax.persistence.*;

@Table(name = "medicine")
@Entity
public class Medicine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "price")
  private String price;

  @ManyToOne
  @JoinColumn(name = "medicine_storage_id", referencedColumnName = "id", nullable = false)
  private MedicineStorage medicineStorage;
  @ManyToOne
  @JoinColumn(name = "medicine_categories_id", referencedColumnName = "id", nullable = false)
  private MedicineCategory medicineCategory;
  @ManyToOne
  @JoinColumn(name = "using_in_life_id", referencedColumnName = "id", nullable = false)

  private UsingInLife usingInLife;


  public Medicine(Integer id, String name, String price, MedicineStorage medicineStorage, MedicineCategory medicineCategory, UsingInLife usingInLife) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.medicineStorage = medicineStorage;
    this.medicineCategory = medicineCategory;
    this.usingInLife = usingInLife;
  }


  public Medicine() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MedicineStorage getMedicineStorage() {
    return medicineStorage;
  }

  public void setMedicineStorage(MedicineStorage medicineStorage) {
    this.medicineStorage = medicineStorage;
  }

  public MedicineCategory getMedicineCategory() {
    return medicineCategory;
  }

  public void setMedicineCategory(MedicineCategory medicineCategories) {
    this.medicineCategory = medicineCategories;
  }

  public UsingInLife getUsingInLife() {
    return usingInLife;
  }

  public void setUsingInLife(UsingInLife usingInLife) {
    this.usingInLife = usingInLife;
  }

  @Override
  public String toString() {
    return "Medicine{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", medicineStorage=" + medicineStorage +
        ", medicineCategories=" + medicineCategory +
        ", usingInLife=" + usingInLife +
        '}';
  }
}
