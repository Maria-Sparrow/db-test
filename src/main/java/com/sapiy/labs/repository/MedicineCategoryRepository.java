package com.sapiy.labs.repository;

import com.sapiy.labs.domain.MedicineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicineCategoryRepository extends JpaRepository<MedicineCategory, Integer> {
}
