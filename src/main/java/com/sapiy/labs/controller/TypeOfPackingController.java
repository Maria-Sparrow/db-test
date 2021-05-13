package com.sapiy.labs.controller;

import com.sapiy.labs.domain.TypeOfPacking;
import com.sapiy.labs.dto.TypeOfPackingDto;
import com.sapiy.labs.service.TypeOfPackingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/typeOfPacking")
@RestController
public class TypeOfPackingController {

  private final TypeOfPackingService typeOfPackingService;

  public TypeOfPackingController(TypeOfPackingService typeOfPackingService) {
    this.typeOfPackingService = typeOfPackingService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<TypeOfPackingDto>> getAll() {
    List<TypeOfPacking> typeOfPack = typeOfPackingService.getAll();
    List<TypeOfPackingDto> typeOfPackingDtos = new ArrayList<>();
    for (TypeOfPacking typeOfPacking : typeOfPack) {
      TypeOfPackingDto typeOfPackingDto = new TypeOfPackingDto (
          typeOfPacking.getId(),
          typeOfPacking.getType()
      );
      typeOfPackingDtos.add(typeOfPackingDto);
    }
    return new ResponseEntity<>(typeOfPackingDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<TypeOfPackingDto> getById(@PathVariable Integer id) {
    TypeOfPacking typeOfPacking = typeOfPackingService.getById(id);
    if (typeOfPacking != null) {
      TypeOfPackingDto typeOfPackingDto = new TypeOfPackingDto(
          typeOfPacking.getId(),
          typeOfPacking.getType()
      );
      return new ResponseEntity<>(typeOfPackingDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody TypeOfPacking newTypeOfPacking) {
    typeOfPackingService.create(newTypeOfPacking);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TypeOfPackingDto> update(@PathVariable Integer id,
                                            @RequestBody TypeOfPacking typeOfPacking) {
    TypeOfPacking typeOfPackingOld = typeOfPackingService.getById(id);
    if (typeOfPackingOld != null) {
      typeOfPackingService.update(id, typeOfPacking);
      TypeOfPackingDto typeOfPackingOldDto = new TypeOfPackingDto(
          typeOfPackingOld.getId(),
          typeOfPackingOld.getType()
      );
      return new ResponseEntity<>(typeOfPackingOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (typeOfPackingService.getById(id) != null) {
      typeOfPackingService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}