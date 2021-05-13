package com.sapiy.labs.controller;

import com.sapiy.labs.domain.MedicineCategory;
import com.sapiy.labs.dto.MedicineCategoryDto;
import com.sapiy.labs.service.MedicineCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/medicineCategory")
@RestController
public class MedicineCategoryController {

  private final MedicineCategoryService medicineCategoryService;

  public MedicineCategoryController(MedicineCategoryService medicineCategoryService) {
    this.medicineCategoryService = medicineCategoryService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<MedicineCategoryDto>> getAll() {
    List<MedicineCategory> medicineCategories = medicineCategoryService.getAll();
    List<MedicineCategoryDto> medicineCategoryDtos = new ArrayList<>();
    for (MedicineCategory medicineCategory : medicineCategories) {
      MedicineCategoryDto medicineCategoryDto = new MedicineCategoryDto (
          medicineCategory.getId(),
          medicineCategory.getMedicine().toString()
      );
      medicineCategoryDtos.add(medicineCategoryDto);
    }
    return new ResponseEntity<>(medicineCategoryDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  // віддаємо на клієнтську частину дані - знову ж таки, віддаємо їх як DTO
  public ResponseEntity<MedicineCategoryDto> getById(@PathVariable Integer id) {
    MedicineCategory medicineCategory = medicineCategoryService.getById(id);
    if (medicineCategory != null) {
      MedicineCategoryDto medicineCategoryDto = new MedicineCategoryDto(
          medicineCategory.getId(),
          medicineCategory.getMedicine().toString()
      );
      return new ResponseEntity<>(medicineCategoryDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody MedicineCategory newMedicineCategory) {
    medicineCategoryService.create(newMedicineCategory);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<MedicineCategoryDto> update(@PathVariable Integer id,
                                           @RequestBody MedicineCategory medicineCategory) {
    MedicineCategory medicineCategoryOld = medicineCategoryService.getById(id);
    if (medicineCategoryOld != null) {
      medicineCategoryService.update(id, medicineCategory);
      MedicineCategoryDto accountOldDto = new MedicineCategoryDto(
          medicineCategoryOld.getId(),
          medicineCategoryOld.getMedicine().toString()
      );
      return new ResponseEntity<>(accountOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (medicineCategoryService.getById(id) != null) {
      medicineCategoryService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}

