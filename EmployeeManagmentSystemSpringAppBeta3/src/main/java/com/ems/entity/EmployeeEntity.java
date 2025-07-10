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
import lombok.NonNull;

@Entity
@Table(name = "MVC_PROJ1_EMS_EMP_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
	@Id
	@Column
	@SequenceGenerator(name = "gen2", sequenceName = "MVC_PROJ1_EMP_SEQ", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String position;

    @Column
    @NonNull
    private String department;

    @Column(unique = true)
    @NonNull
    private String email;
    
    @Column(unique = true)
    @NonNull
    private Long phn;
    
    @Column
    @NonNull
    private Double salary;
}
