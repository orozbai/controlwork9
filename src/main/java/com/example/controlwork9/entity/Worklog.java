package com.example.controlwork9.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "worklogs")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private String description;
    private LocalDateTime created;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worklog")
    @OrderBy("name ASC")
    private List<Task> tasks;
}
