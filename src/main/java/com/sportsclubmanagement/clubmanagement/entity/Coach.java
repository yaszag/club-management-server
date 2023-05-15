package com.sportsclubmanagement.clubmanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "coaches")
    private List<Activity> activities;

}