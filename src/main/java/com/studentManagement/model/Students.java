package com.studentManagement.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department;
    private LocalDate enrollmentDate;

	@OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private List<Documents> documents;
}
