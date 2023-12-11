package com.example.springjava.repo;

import com.example.springjava.model.SingleTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleTestRepository extends JpaRepository<SingleTest,Long> {
}
