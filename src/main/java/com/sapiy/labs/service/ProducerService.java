package com.sapiy.labs.service;

import com.sapiy.labs.domain.Producer;
import com.sapiy.labs.repository.ProducerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService implements MedService<Producer, Integer> {

  private final ProducerRepository producerRepository;

  public ProducerService(ProducerRepository producerRepository) {
    this.producerRepository = producerRepository;
  }

  @Override
  public List<Producer> getAll() {
    return producerRepository.findAll();
  }

  @Override
  public Producer getById(Integer id) {
    return producerRepository.getOne(id);
  }

  @Override
  public Producer create(Producer producers) {
    return producerRepository.save(producers);
  }

  @Override
  public Producer update(Integer id, Producer producer) {
    if (producerRepository.findById(id).isPresent()) {
      return producerRepository.save(producer);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (producerRepository.findById(id).isPresent()) {
      producerRepository.deleteById(id);
    }
  }

}
