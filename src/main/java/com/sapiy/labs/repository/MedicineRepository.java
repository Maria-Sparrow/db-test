package com.sapiy.labs.repository;

import com.sapiy.labs.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

  List<Medicine> getMedicineByMedicineCategoryId(Integer id);

  List<Medicine> getMedicineByMedicineStorageId(Integer id);

  List<Medicine> getMedicineByUsingInLifeId(Integer id);

}