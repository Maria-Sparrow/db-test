package com.sapiy.labs.controller;

import com.sapiy.labs.domain.Producer;
import com.sapiy.labs.dto.ProducerDto;
import com.sapiy.labs.service.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/producer")
@RestController
public class ProducerController {

  private final ProducerService producerService;

  public ProducerController(ProducerService producerService) {
    this.producerService = producerService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ProducerDto>> getAll() {
    List<Producer> producers = producerService.getAll();
    List<ProducerDto> producerDtos = new ArrayList<>();
    for (Producer producer : producers) {
      ProducerDto producerDto = new ProducerDto (
          producer.getId(),
          producer.getNameProducer()
      );
      producerDtos.add(producerDto);
    }
    return new ResponseEntity<>(producerDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<ProducerDto> getById(@PathVariable Integer id) {
    Producer producer = producerService.getById(id);
    if (producer != null) {
      ProducerDto producerDto = new ProducerDto(
          producer.getId(),
          producer.getNameProducer()
      );
      return new ResponseEntity<>(producerDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Producer newProducer) {

    producerService.create(newProducer);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ProducerDto> update(@PathVariable Integer id,
                                                   @RequestBody Producer producer) {
    Producer producerOld = producerService.getById(id);
    if (producerOld != null) {
      producerService.update(id, producer);
      ProducerDto producerOldDto = new ProducerDto(
          producerOld.getId(),
          producerOld.getNameProducer()
      );
      return new ResponseEntity<>(producerOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (producerService.getById(id) != null) {
      producerService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
