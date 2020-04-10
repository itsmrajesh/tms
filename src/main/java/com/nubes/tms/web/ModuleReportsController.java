package com.nubes.tms.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nubes.tms.reports.dto.ModuleCountDTO;
import com.nubes.tms.reports.dto.ModulePriorityDTO;
import com.nubes.tms.reports.dto.ModuleStatusDTO;
import com.nubes.tms.reports.service.ModuleReportsService;

@RestController
@RequestMapping("/api/modulereports/")
public class ModuleReportsController {
	
	@Autowired
	private ModuleReportsService moduleReportsService;
	
	@GetMapping("/getissuecount")
	public List<ModuleCountDTO> getModuleIssuesCount(){
		List<ModuleCountDTO> modCount = moduleReportsService.getModuleIssuesCount();
		return modCount;
		
	}
	
	@GetMapping("/getorgissuecount/{orgname}")
	public List<ModuleCountDTO> getModuleIssuesCountByOrg(@PathVariable("orgname") String orgName){
		List<ModuleCountDTO> modCount = moduleReportsService.getModuleIssuesCountByOrg(orgName);
		return modCount;
		
	}
	
	@GetMapping("/getprioritycount/{modname}")
	public List<ModulePriorityDTO> getModulePriorityCount(@PathVariable("modname") String modName){
		List<ModulePriorityDTO> modPriorityCount = moduleReportsService.getModulePriorityCount(modName);
		return modPriorityCount;
		
	}
	
	@GetMapping("/getstatuscount/{modname}")
	public List<ModuleStatusDTO> getModuleStatusCount(@PathVariable("modname") String modName){
		List<ModuleStatusDTO> modStatusCount = moduleReportsService.getModuleStatusCount(modName);
		return modStatusCount;
		
	}
	
	
	
	
	

}
