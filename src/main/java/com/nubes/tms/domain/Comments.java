package com.nubes.tms.domain;
import java.time.LocalDateTime;
import com.nubes.tms.auth.config.ContextUserUtil;

public class Comments {

	private final String userName;
	private String description;
	private final LocalDateTime createdAt;

	public Comments() {
		userName = ContextUserUtil.userName();
		createdAt = LocalDateTime.now();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
