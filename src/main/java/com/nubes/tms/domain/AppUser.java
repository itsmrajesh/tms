package com.nubes.tms.domain;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppUser{

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String orgName;
	private Set<Role> roles;
	@Builder.Default
	private boolean status = true;

	private String password;


    @CreatedBy
	private String createdBy;

	@CreatedDate
	private Instant createdDate;

	@LastModifiedBy
	private String lastModifiedUser;

	@LastModifiedDate
	private Instant lastModifiedDate;

	
}