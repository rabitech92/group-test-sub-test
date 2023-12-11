package com.example.springjava.service;

import com.example.springjava.model.GroupTest;
import com.example.springjava.repo.GroupTestRepository;
import com.example.springjava.repo.SingleTestRepository;
import com.example.springjava.repo.SingleTestSequenceRepository;
import com.example.springjava.repo.SubTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupTestService {

    private final GroupTestRepository repository;
    private final SubTestRepository subTestRepository;
    private final SingleTestRepository singleTestRepository;
    private final SingleTestSequenceRepository singleTestSequenceRepository;

    public List<GroupTest> getAll() {
        return repository.findAll();
    }

    public GroupTest save(GroupTest groupTest) {
        subTestRepository.save(groupTest.getSubTestList().get(groupTest));
        return repository.save(groupTest);
    }
}
