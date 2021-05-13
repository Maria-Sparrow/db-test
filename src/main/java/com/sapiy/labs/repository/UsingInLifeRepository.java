package com.sapiy.labs.repository;

import com.sapiy.labs.domain.Medicine;
import com.sapiy.labs.domain.UsingInLife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsingInLifeRepository extends JpaRepository<UsingInLife, Integer> {
}