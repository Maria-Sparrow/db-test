package com.sapiy.labs.service;

import com.sapiy.labs.domain.TypeOfPacking;
import com.sapiy.labs.repository.TypeOfPackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfPackingService implements MedService<TypeOfPacking, Integer> {

  private final TypeOfPackingRepository typeOfPackingRepository;

  public TypeOfPackingService(TypeOfPackingRepository typeOfPackingRepository) {
    this.typeOfPackingRepository = typeOfPackingRepository;
  }

  @Override
  public List<TypeOfPacking> getAll() {
    return typeOfPackingRepository.findAll();
  }

  @Override
  public TypeOfPacking getById(Integer id) {
    return typeOfPackingRepository.getOne(id);
  }

  @Override
  public TypeOfPacking create(TypeOfPacking typeOfPack) {
    return typeOfPackingRepository.save(typeOfPack);
  }

  @Override
  public TypeOfPacking update(Integer id, TypeOfPacking typeOfPacking) {
    if (typeOfPackingRepository.findById(id).isPresent()) {
      return typeOfPackingRepository.save(typeOfPacking);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (typeOfPackingRepository.findById(id).isPresent()) {
      typeOfPackingRepository.deleteById(id);
    }
  }

}
