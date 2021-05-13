package com.sapiy.labs.controller;

import com.sapiy.labs.domain.MedicineStorage;
import com.sapiy.labs.dto.MedicineStorageDto;
import com.sapiy.labs.service.MedicineStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/medicineStorage")
@RestController
public class MedicineStorageController {

  private final MedicineStorageService medicineStorageService;

  public MedicineStorageController(MedicineStorageService medicineStorageService) {
    this.medicineStorageService = medicineStorageService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<MedicineStorageDto>> getAll() {
    // стягуємо всі ентіті
    List<MedicineStorage> medicineStorages = medicineStorageService.getAll();
    // створюємо (поки що) пустий список для DTOшок
    List<MedicineStorageDto> medicineStorageDtos = new ArrayList<>();
    // перебираємо кожен ентіті, що ми знайшли, конвертуємо в DTO і додаємо DTO до ліста
    for (MedicineStorage medicineStorage : medicineStorages) {
      MedicineStorageDto medicineStorageDto = new MedicineStorageDto (
          medicineStorage.getId(), // сетаємо значення для id
          medicineStorage.getMedicines().toString()
      );
      medicineStorageDtos.add(medicineStorageDto);
    }
    return new ResponseEntity<>(medicineStorageDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  // віддаємо на клієнтську частину дані - знову ж таки, віддаємо їх як DTO
  public ResponseEntity<MedicineStorageDto> getById(@PathVariable Integer id) {
    MedicineStorage medicineStorage = medicineStorageService.getById(id);
    if (medicineStorage != null) {
      MedicineStorageDto medicineStorageDto = new MedicineStorageDto(
          medicineStorage.getId(),
          medicineStorage.getMedicines().toString()
      );
      return new ResponseEntity<>(medicineStorageDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // параметр consumes  POST в нас хаває дані теж в форматі JSON
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody MedicineStorage newMedicineStorage) {

    medicineStorageService.create(newMedicineStorage);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<MedicineStorageDto> update(@PathVariable Integer id,
                                            @RequestBody MedicineStorage medicineStorage) {
    MedicineStorage medicineStorageOld = medicineStorageService.getById(id);
    if (medicineStorageOld != null) {
      medicineStorageService.update(id, medicineStorage);
      MedicineStorageDto medicineStorageOldDto = new MedicineStorageDto(
          medicineStorageOld.getId(),
          medicineStorageOld.getMedicines().toString()
      );
      return new ResponseEntity<>(medicineStorageOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (medicineStorageService.getById(id) != null) {
      medicineStorageService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
