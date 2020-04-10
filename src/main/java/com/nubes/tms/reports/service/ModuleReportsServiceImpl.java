package com.nubes.tms.reports.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nubes.tms.reports.dao.ModuleReportsDao;
import com.nubes.tms.reports.dto.ModuleCountDTO;
import com.nubes.tms.reports.dto.ModulePriorityDTO;
import com.nubes.tms.reports.dto.ModuleStatusDTO;

@Service
public class ModuleReportsServiceImpl implements ModuleReportsService {
	
	private static final Logger log = LoggerFactory.getLogger(ModuleReportsServiceImpl.class);
	
	@Autowired
	private ModuleReportsDao moduleReportsDao;

	@Override
	public List<ModuleCountDTO> getModuleIssuesCount() {
		 List<ModuleCountDTO> modCount = moduleReportsDao.getModuleIssuesCount();
		 log.info("Total modules with issues are:{}", modCount.size());
		return modCount;
	}

	@Override
	public List<ModuleCountDTO> getModuleIssuesCountByOrg(String orgName) {
		 List<ModuleCountDTO> modCount = moduleReportsDao.getModuleIssuesCountByOrg(orgName);
		 log.info("Total modules of organization with issues are:{}", modCount.size());
		return modCount;
	}

	@Override
	public List<ModulePriorityDTO> getModulePriorityCount(String mName) {
		List<ModulePriorityDTO> modPriorityCount = moduleReportsDao.getModulePriorityCount(mName);
		log.info("Module is having total of {} priorities",modPriorityCount.size());
		return modPriorityCount;
	}

	@Override
	public List<ModuleStatusDTO> getModuleStatusCount(String mName) {
		List<ModuleStatusDTO> modStatusCount = moduleReportsDao.getModuleStatusCount(mName);
		log.info("Module is having total of {} status", modStatusCount.size());
		return modStatusCount;
	}
	
	

}
