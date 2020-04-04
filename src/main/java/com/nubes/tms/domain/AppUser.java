package com.nubes.tms.domain;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser implements AuditorAware<String> {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String orgName;
	@JsonIgnore
	private String password;

	@CreatedBy
	private String user;
	@CreatedDate
	private Instant createdDate;

	@LastModifiedBy
	private String lastModifiedUser;

	@LastModifiedDate
	private Instant lastModifiedDate;

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("");
	}

}