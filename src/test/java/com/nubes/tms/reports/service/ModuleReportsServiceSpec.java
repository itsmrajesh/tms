package com.nubes.tms.reports.service;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nubes.tms.domain.Module;
import com.nubes.tms.issue.test.SeedData;
import com.nubes.tms.repo.ModuleRepo;
import com.nubes.tms.reports.dao.ModuleReportsDao;

@SpringBootTest
public class ModuleReportsServiceSpec {
	
	@Autowired
	private SeedData seedDate;
	
	@Autowired
	private ModuleReportsDao moduleReportsDao;
	
	@Autowired
	private ModuleRepo moduleRepo;
	
	@BeforeEach
	public void init() throws IOException {
		List<Module> module = seedDate.loadDataFromModuleFile();
		moduleRepo.saveAll(module);
	}

	@AfterEach
	public void destory() {
		moduleRepo.deleteAll();
	}
	
	@Test
	public void getModuleIssuesCount() {
		
	}
	
	@Test
	public void getModuleIssuesCountByOrg() {
		
	}
	
	@Test
	public void getModulePriorityCount() {
		
	}
	
	@Test
	public void getModuleStatusCount() {
		
	}
	

}
