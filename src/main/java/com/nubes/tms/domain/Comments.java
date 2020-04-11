package com.nubes.tms.domain;

import java.time.LocalDateTime;

import com.nubes.tms.auth.config.ContextUserUtil;

import lombok.Getter;

@Getter
public class Comments {

	private String userName = ContextUserUtil.userName();
	private String description;
	private LocalDateTime createdAt = LocalDateTime.now();

}
