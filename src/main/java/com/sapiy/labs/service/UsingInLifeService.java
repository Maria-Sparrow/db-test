package com.sapiy.labs.service;


import com.sapiy.labs.domain.Medicine;
import com.sapiy.labs.domain.UsingInLife;
import com.sapiy.labs.repository.UsingInLifeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsingInLifeService implements MedService<UsingInLife, Integer> {

  private final UsingInLifeRepository usingInLifeRepository;

  public UsingInLifeService(UsingInLifeRepository usingInLifeRepository) {
    this.usingInLifeRepository = usingInLifeRepository;
  }

  @Override
  public List<UsingInLife> getAll() {
    return usingInLifeRepository.findAll();
  }

  @Override
  public UsingInLife getById(Integer id) {
    return usingInLifeRepository.getOne(id);
  }

  @Override
  public UsingInLife create(UsingInLife using) {
    return usingInLifeRepository.save(using);
  }

  @Override
  public UsingInLife update(Integer id, UsingInLife usingInLife) {
    if (usingInLifeRepository.findById(id).isPresent()) {
      return usingInLifeRepository.save(usingInLife);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (usingInLifeRepository.findById(id).isPresent()) {
      usingInLifeRepository.deleteById(id);
    }
  }

}
