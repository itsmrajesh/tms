package com.nubes.tms.reports.dto;

import com.nubes.tms.domain.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModuleStatusDTO {

	private Status status;
	
	private int count;
	
}
