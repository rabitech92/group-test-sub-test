package com.example.springjava.service;

import com.example.springjava.dto.GroupTestDto;
import com.example.springjava.dto.SubTestDto;
import com.example.springjava.model.GroupTest;
import com.example.springjava.model.SubTest;
import com.example.springjava.repo.GroupTestRepository;
import com.example.springjava.repo.SingleTestRepository;
import com.example.springjava.repo.SingleTestSequenceRepository;
import com.example.springjava.repo.SubTestRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupTestService {

    private final GroupTestRepository repository;
    private final SubTestRepository subTestRepository;
    private final SingleTestRepository singleTestRepository;
    private final SingleTestSequenceRepository singleTestSequenceRepository;
    private final ModelMapper modelMapper;

    public List<GroupTest> getAll() {
        return repository.findAll();
    }

    public GroupTest save(GroupTest groupTest) {
        return repository.save(groupTest);
    }

    public void updateGroup(Long id, GroupTestDto groupTestDto) {
        GroupTest groupTest = repository.findById(id).get();
        groupTest.getSubTestList().clear();

        groupTest.setGroupTestName(groupTestDto.getGroupTestName());
        List<SubTestDto> updateSubTestDto = groupTestDto.getSubTestList();
        List<SubTest> existSubtest = groupTest.getSubTestList();

        for (SubTestDto updateSubTestDto1 : updateSubTestDto) {
            Optional<SubTest> existingSubTestOptional = existSubtest.stream()
                    .filter(subTest -> subTest.getId() == (updateSubTestDto1.getId())).findFirst();

            if (existingSubTestOptional.isPresent()) {
                SubTest existingSubTest = existingSubTestOptional.get();
                // Create a new SubTest object from the SubTestDto
                SubTest updatedSubTestEntity = new SubTest();
                updatedSubTestEntity.setId(existingSubTest.getId());
                updatedSubTestEntity.setSubTestName(existingSubTest.getSubTestName());
                updatedSubTestEntity.setSingleTestList(existingSubTest.getSingleTestList());
                updatedSubTestEntity.setSingleTestSequences(existingSubTest.getSingleTestSequences());
                    // Set other properties...

                    // Update the existing SubTest with the new values
                existSubtest.set(existSubtest.indexOf(existingSubTest), updatedSubTestEntity);
            }
            else {
                // Add new SubTest
                // Assuming that you need to convert SubTestDto to SubTest here
                SubTest newSubTest = convertDtoToEntity(updateSubTestDto1);
                existSubtest.add(newSubTest);
            }
        }

    }
    private SubTest convertDtoToEntity(SubTestDto subTestDto) {
        SubTest subTest = new SubTest();
        subTest.setId(subTestDto.getId());
        SubTestDto testDto = modelMapper.map(subTest, SubTestDto.class);
        testDto.setSingleTestList(subTestDto.getSingleTestList());
        testDto.setSingleTestSequences(subTestDto.getSingleTestSequences());
        modelMapper.map(testDto, subTest);
        // Set other properties...
        return subTest;
    }
}
