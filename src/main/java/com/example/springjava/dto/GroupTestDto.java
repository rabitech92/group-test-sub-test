package com.example.springjava.dto;

import com.example.springjava.model.SubTest;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupTestDto {
    @Id
    private Long id;
    private String groupTestName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubTestDto> subTestList;
}
