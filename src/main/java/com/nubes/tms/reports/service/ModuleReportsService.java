package com.nubes.tms.reports.service;

import java.util.List;

import com.nubes.tms.reports.dto.ModuleCountDTO;
import com.nubes.tms.reports.dto.ModulePriorityDTO;
import com.nubes.tms.reports.dto.ModuleStatusDTO;

public interface ModuleReportsService {
	
	public List<ModuleCountDTO> getModuleIssuesCount();
	
	public List<ModuleCountDTO> getModuleIssuesCountByOrg(String orgName);
	
    public List<ModulePriorityDTO> getModulePriorityCount(String mName);
	
	public List<ModuleStatusDTO> getModuleStatusCount(String mName);



}
