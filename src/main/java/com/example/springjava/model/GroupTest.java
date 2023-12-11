package com.example.springjava.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupTest{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupTestName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubTest> subTestList;
}
