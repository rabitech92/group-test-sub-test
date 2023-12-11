package com.example.springjava.repo;

import com.example.springjava.model.GroupTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTestRepository extends JpaRepository<GroupTest,Long> {

}
