package com.example.springjava.dto;

import com.example.springjava.model.SingleTest;
import com.example.springjava.model.SingleTestSequence;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubTestDto {
    @Id
    private Long id;
    private String subTestName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SingleTest> singleTestList;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<SingleTestSequence> singleTestSequences;
}
