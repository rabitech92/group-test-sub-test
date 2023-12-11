package com.example.springjava.repo;

import com.example.springjava.model.SubTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTestRepository extends JpaRepository<SubTest,Long> {
}
