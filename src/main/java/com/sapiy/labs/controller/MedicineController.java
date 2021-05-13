package com.sapiy.labs.controller;

import com.sapiy.labs.domain.Medicine;
import com.sapiy.labs.dto.MedicineDto;
import com.sapiy.labs.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/medicine")
@RestController
public class MedicineController {

  private final MedicineService medicineService;

  public MedicineController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<MedicineDto>> getAll() {
    List<Medicine> medicines = medicineService.getAll();
    List<MedicineDto> medicineDtos = new ArrayList<>();
    for (Medicine medicine : medicines) {
      MedicineDto medicineDto = new MedicineDto (
          medicine.getId(), // сетаємо значення для id
          medicine.getName(),
          medicine.getPrice()
      );
      medicineDtos.add(medicineDto);
    }
    return new ResponseEntity<>(medicineDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<MedicineDto> getById(@PathVariable Integer id) {
    Medicine medicine = medicineService.getById(id);

    if (medicine != null) {
      MedicineDto medicineDto = new MedicineDto(
          medicine.getId(),
          medicine.getName(),
          medicine.getPrice()
      );
      return new ResponseEntity<>(medicineDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Medicine newMedicine) {

    medicineService.create(newMedicine);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<MedicineDto> update(@PathVariable Integer id,
                                                    @RequestBody Medicine medicine) {
    Medicine medicineOld = medicineService.getById(id);
    if (medicineOld != null) {
      medicineService.update(id, medicine);
      MedicineDto medicineOldDto = new MedicineDto(
          medicineOld.getId(),
          medicineOld.getName(),
          medicineOld.getPrice()
      );
      return new ResponseEntity<>(medicineOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (medicineService.getById(id) != null) {
      medicineService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/by-category/{id}")
  public List<Medicine> getAllByMedicineCategoryId(@PathVariable Integer id){
    List<Medicine> medicines = medicineService.getAllByMedicineCategoryId(id);
   return medicines;
  }
  @RequestMapping(method = RequestMethod.GET, value = "/by-storage/{id}")
  public List<Medicine> getAllByMedicineStorageId(@PathVariable Integer id){
    List<Medicine> medicines = medicineService.getAllByMedicineStorageId(id);
    return medicines;
  }
  @RequestMapping(method = RequestMethod.GET, value = "/by-using/{id}")
  public List<Medicine> getAllByUsingInLifeId(@PathVariable Integer id){
    List<Medicine> medicines = medicineService.getAllByUsingInLifeId(id);
    return medicines;
  }
}
