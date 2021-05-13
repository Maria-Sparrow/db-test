package com.sapiy.labs.repository;


import com.sapiy.labs.domain.TypeOfPacking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfPackingRepository extends JpaRepository<TypeOfPacking, Integer> {

}