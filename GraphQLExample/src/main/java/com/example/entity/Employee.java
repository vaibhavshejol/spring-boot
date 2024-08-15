package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;
}
