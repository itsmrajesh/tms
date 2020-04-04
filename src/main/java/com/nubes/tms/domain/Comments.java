package com.nubes.tms.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {

	private String userName;
	private String description;

	@CreatedDate
	private LocalDateTime createdAt;

}
