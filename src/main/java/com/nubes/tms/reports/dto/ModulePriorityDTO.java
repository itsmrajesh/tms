package com.nubes.tms.reports.dto;

import com.nubes.tms.domain.Priority;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModulePriorityDTO {
	
	private Priority priority; 
	
	private int count;
	
}
