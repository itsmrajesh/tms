package com.nubes.tms.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {

	private String userName;
	private String description;
	private LocalDateTime createdAt = LocalDateTime.now();

}
