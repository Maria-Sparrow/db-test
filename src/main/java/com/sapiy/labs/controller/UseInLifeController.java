package com.sapiy.labs.controller;

import com.sapiy.labs.domain.UsingInLife;
import com.sapiy.labs.dto.UsingInLifeDto;
import com.sapiy.labs.service.UsingInLifeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/usingInLife")
@RestController
public class UseInLifeController {

  private final UsingInLifeService usingInLifeService;

  public UseInLifeController(UsingInLifeService usingInLifeService) {
    this.usingInLifeService = usingInLifeService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UsingInLifeDto>> getAll() {
    List<UsingInLife> usingInLives = usingInLifeService.getAll();
    List<UsingInLifeDto> usingInLifeDtos = new ArrayList<>();
    for (UsingInLife usingInLife : usingInLives) {
      UsingInLifeDto usingInLifeDto = new UsingInLifeDto (
          usingInLife.getId(),
          usingInLife.getMedicines().toString()
      );
      usingInLifeDtos.add(usingInLifeDto);
    }
    return new ResponseEntity<>(usingInLifeDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<UsingInLifeDto> getById(@PathVariable Integer id) {
    UsingInLife usingInLife = usingInLifeService.getById(id);
    if (usingInLife != null) {
      UsingInLifeDto usingInLifeDto = new UsingInLifeDto(
          usingInLife.getId(),
          usingInLife.getMedicines().toString()
      );
      return new ResponseEntity<>(usingInLifeDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody UsingInLife newUsingInLife) {
    usingInLifeService.create(newUsingInLife);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UsingInLifeDto> update(@PathVariable Integer id,
                                                 @RequestBody UsingInLife usingInLife) {
    UsingInLife usingInLifeOld = usingInLifeService.getById(id);
    if (usingInLifeOld != null) {
      usingInLifeService.update(id, usingInLife);
      UsingInLifeDto usingInLifeOldDto = new UsingInLifeDto(
          usingInLifeOld.getId(),
          usingInLifeOld.getMedicines().toString()
      );
      return new ResponseEntity<>(usingInLifeOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (usingInLifeService.getById(id) != null) {
      usingInLifeService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}