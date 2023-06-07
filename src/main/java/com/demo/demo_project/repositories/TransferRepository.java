package com.demo.demo_project.repositories;

import com.demo.demo_project.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
