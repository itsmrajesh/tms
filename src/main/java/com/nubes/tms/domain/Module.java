package com.nubes.tms.domain;

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
public class Module {

	@Id
	private String id;
	private String name;
	private String userName;
	private String email;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private String createdDate;

	@LastModifiedBy
	private String lastModifiedUser;

	@LastModifiedDate
	private String lastModifiedDate;

}
