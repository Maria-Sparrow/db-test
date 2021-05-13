package com.sapiy.labs.service;


import com.sapiy.labs.domain.MedicineStorage;
import com.sapiy.labs.repository.MedicineStorageRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicineStorageService implements MedService<MedicineStorage, Integer> {

  private final MedicineStorageRepository medicineStorageRepository;

  public MedicineStorageService(MedicineStorageRepository medicineStorageRepository) {
    this.medicineStorageRepository = medicineStorageRepository;
  }

  @Override
  public List<MedicineStorage> getAll() {
    return medicineStorageRepository.findAll();
  }

  @Override
  public MedicineStorage getById(Integer id) {
    return medicineStorageRepository.getOne(id);
  }

  @Override
  public MedicineStorage create(MedicineStorage newMedicineStorages) {
    return medicineStorageRepository.save(newMedicineStorages);
  }

  @Override
  public MedicineStorage update(Integer id, MedicineStorage medicineStorages) {
    if (medicineStorageRepository.findById(id).isPresent()) {
      return medicineStorageRepository.save(medicineStorages);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (medicineStorageRepository.findById(id).isPresent()) {
      medicineStorageRepository.deleteById(id);
    }
  }

}
