package com.nubes.tms.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;

import com.nubes.tms.auth.config.ContextUsesrUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issue implements AuditorAware<String> {

	@Id
	private String id;
	private String problemStatement;
	private String module;
	private Priority priority;
	private Status status;
	private String description;
	private List<Comments> comments;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Instant createdDate;

	@CreatedDate
	private LocalDateTime createAt;

	@LastModifiedDate
	private LocalDateTime updateAt;

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(ContextUsesrUtil.userName());

	}

}