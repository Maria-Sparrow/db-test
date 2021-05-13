package com.sapiy.labs.repository;

import com.sapiy.labs.domain.Medicine;
import com.sapiy.labs.domain.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineStorageRepository extends JpaRepository<MedicineStorage, Integer> {
}