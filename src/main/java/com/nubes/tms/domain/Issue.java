package com.nubes.tms.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

	private String id;
	private String problemStatement;
	private String module;
	private Priority priority; // Enum
	private Status status; // Enum
	private String description;
	private List<Comments> comments;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private String createdBy;

	
}