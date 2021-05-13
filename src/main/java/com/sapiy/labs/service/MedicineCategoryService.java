package com.sapiy.labs.service;

import com.sapiy.labs.domain.MedicineCategory;
import com.sapiy.labs.repository.MedicineCategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineCategoryService implements MedService<MedicineCategory, Integer> {

  private final MedicineCategoryRepository medicineCategoryRepository;

  public MedicineCategoryService(MedicineCategoryRepository medicineCategoryRepository) {
    this.medicineCategoryRepository = medicineCategoryRepository;
  }

  @Override
  public List<MedicineCategory> getAll() {
    return medicineCategoryRepository.findAll();
  }

  @Override
  public MedicineCategory getById(Integer id) {
    return medicineCategoryRepository.getOne(id);
  }

  @Override
  public MedicineCategory create(MedicineCategory newMedicineCategories) {
    return medicineCategoryRepository.save(newMedicineCategories);
  }

  @Override
  public MedicineCategory update(Integer id, MedicineCategory medicineCategories) {
    if (medicineCategoryRepository.findById(id).isPresent()) {
      return medicineCategoryRepository.save(medicineCategories);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (medicineCategoryRepository.findById(id).isPresent()) {
      medicineCategoryRepository.deleteById(id);
    }
  }

}
