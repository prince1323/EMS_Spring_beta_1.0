package com.ems.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MVC_PROJ1_EMS_DEPT_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_gen")
	    @SequenceGenerator(name = "dept_gen", sequenceName = "MVC_PROJ1_DEPT_SEQ", initialValue = 100, allocationSize = 1)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String name;

	    @Column(name = "active_projects")
	    private Integer activeProjects;

	    @Column(name = "completed_projects")
	    private Integer completedProjects;

	    @Column(name = "active_employees")
	    private Integer activeEmployees;
}
