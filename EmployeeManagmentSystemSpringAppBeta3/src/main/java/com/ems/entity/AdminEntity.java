package com.ems.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MVC_PROJ1_EMS_ADMIN_ENTITY")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AdminEntity {
	@Id
	@Column
	@SequenceGenerator(name = "gen1", sequenceName = "MVC_PROJ1_ADMIN_SEQ", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long id; // Unique identifier
	
	@Column
	@NonNull
	private String username; // Admin login username
	
	@Column
	@NonNull
	private String password; // Hashed password (use proper encryption)
	
	@Column
	@NonNull
	private String email; // Email address
	
	@Column
	@NonNull
	private String fullName; // Admin full name
	
	@Column
	@NonNull
	private String phoneNumber; // Optional: contact info
	
	@Column
	@NonNull
	private String role; // e.g., 'SUPER_ADMIN', 'HR_ADMIN'
	
	@Column
	@NonNull
	private LocalDateTime createdAt; // Account creation date
	
	@Column
	@NonNull
	private LocalDateTime lastLogin; // Last login timestamp
	
	@Column
	@NonNull
	private Boolean isActive; // Account active/inactive status

}
