package com.ems.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "MVC_PROJ1_PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
	  @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proj_gen")
	    @SequenceGenerator(name = "proj_gen", sequenceName = "MVC_PROJ1_PROJ_SEQ", initialValue = 500, allocationSize = 1)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String status; // "Active" or "Completed"

	    @ManyToOne
	    @JoinColumn(name = "department_id", nullable = false)
	    private DepartmentEntity department;

	    @Column(name = "employee_count")
	    private Integer employeeCount;
}
