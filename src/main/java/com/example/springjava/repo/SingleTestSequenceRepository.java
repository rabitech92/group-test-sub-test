package com.example.springjava.repo;

import com.example.springjava.model.SingleTestSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleTestSequenceRepository extends JpaRepository<SingleTestSequence,Long> {
}
