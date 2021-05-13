package com.sapiy.labs.service;

import com.sapiy.labs.domain.Medicine;
import com.sapiy.labs.domain.UsingInLife;
import com.sapiy.labs.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements MedService<Medicine, Integer> {

  private final MedicineRepository medicineRepository;

  public MedicineService(MedicineRepository medicineRepository) {
    this.medicineRepository = medicineRepository;
  }

  @Override
  public List<Medicine> getAll() {
    return medicineRepository.findAll();
  }

  @Override
  public Medicine getById(Integer id) {
    return medicineRepository.getOne(id);
  }

  @Override
  public Medicine create(Medicine newMedicine) {
    return medicineRepository.save(newMedicine);
  }

  @Override
  public Medicine update(Integer id, Medicine medicine) {
    if (medicineRepository.findById(id).isPresent()) {
      return medicineRepository.save(medicine);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (medicineRepository.findById(id).isPresent()) {
      medicineRepository.deleteById(id);
    }
  }

  public List<Medicine> getAllByUsingInLifeId(Integer id) {
    return medicineRepository.getMedicineByUsingInLifeId(id);
  }
  public List<Medicine> getAllByMedicineCategoryId(Integer id) {
    return medicineRepository.getMedicineByMedicineCategoryId(id);
  }
  public List<Medicine> getAllByMedicineStorageId(Integer id) {
    return medicineRepository.getMedicineByMedicineStorageId(id);
  }


}
