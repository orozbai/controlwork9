package com.example.controlwork9.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "statuses")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
    @OrderBy("name ASC")
    private List<Task> tasks;
}
