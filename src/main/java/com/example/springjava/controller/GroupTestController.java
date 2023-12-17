package com.example.springjava.controller;

import com.example.springjava.dto.GroupTestDto;
import com.example.springjava.model.GroupTest;
import com.example.springjava.service.GroupTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class GroupTestController {

    private final GroupTestService service;

    @GetMapping("/get-all")
    public List<GroupTest> getAll() {
        System.out.println("Hello dockerize with spring boot");
        return service.getAll();
    }

    @PostMapping
    public GroupTest save(@RequestBody GroupTest groupTest){
        return service.save(groupTest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody GroupTestDto groupTestDto,@PathVariable Long id){
         service.updateGroup(id,groupTestDto);
    }
}
