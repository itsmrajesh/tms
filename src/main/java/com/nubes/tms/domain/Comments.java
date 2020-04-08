package com.nubes.tms.domain;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AuditorAware;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {

	private String userName;
	private String description;
	private LocalDateTime createdAt = LocalDateTime.now();

}
