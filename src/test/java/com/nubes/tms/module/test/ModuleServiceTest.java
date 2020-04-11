package com.nubes.tms.module.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.nubes.tms.domain.Module;
import com.nubes.tms.exceptions.ModuleExistsException;
import com.nubes.tms.issue.test.SeedData;
import com.nubes.tms.repo.ModuleRepo;
import com.nubes.tms.service.ModuleService;

@SpringBootTest
public class ModuleServiceTest {
	
	@Autowired
	private SeedData seedDate;
	
	@Autowired
	private ModuleRepo moduleRepo;
	
	@Autowired
	private ModuleService moduleService;
	
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
	public void getAllModules() {
		List<Module> list = moduleService.viewModules();
		System.out.println("Size of modules:" + list.size());
		assertEquals(2, list.size());
	}
	
	@Test
    public void addModule() throws ModuleExistsException {
		Module module = moduleService.addModule(Module.builder().name("Login").userName("Asha").email("asha@gmail.com").build());
		System.out.println("Module with this name already exist so no data added so size of list is 2 and actual result is ");
		getAllModules();
		Assertions.assertThat(module).isNull();
		
	}
	
	@Test
	public void getModuleByName() {
		String name = "Login";
		Module module = moduleService.getModuleByName(name);
		System.out.println("Module name is "+module.getName()+" User name is "+module.getUserName()+" Email is "+module.getUserName());
		Assertions.assertThat(module).isNotNull();
		
		String name1 = "Application";
		Module module1 = moduleService.getModuleByName(name1);
		System.out.println("Module should be null and the actual result is "+module1);
		Assertions.assertThat(module1).isNull();
		
		String name2 = " ";
		Module module2 = moduleService.getModuleByName(name2);
		System.out.println("Module name should be null and the actual result is"+module2);
		Assert.notNull(name2, "Name of the module cannot be null");
	}
	
	@Test
	public void updateModule() throws ModuleExistsException {
		String name = "Login";
		Module module = Module.builder().name("Dashboard").userName("Asha").email("asha@gmail.com").build();
		module = moduleService.updateModule(module, name);
		System.out.println("Module updated with name : "+module.getName());
		Assertions.assertThat(module).isNotNull();
		
		String name1 = " ";
		Module module1 = Module.builder().name("Dashboard").userName("Mrudulla").email("mrudulla@gmail.com").build();
		module1 = moduleService.updateModule(module1, name1);
		System.out.println("Module name cant be empty so module not updated ");
		Assert.notNull(name1, "Name of the module to be updated cannot be null");
		
		String name2 = "Dashboard";
		Module module2 = null;
		module2 = moduleService.updateModule(module2, name2);
		System.out.println("Module details is empty so not updated "+module2);
		Assert.notNull(module2, "Module to be updated cannot be null");
	}
	
	@Test
	public void deleteModule() {
		String name = "Dashboard";
		boolean status = moduleService.deleteModule(name);
		System.out.println("Module should be deleted successfuly and return TRUE, actual result is "+status);
		Assertions.assertThat(status).isEqualTo(true);
		
		String name1 = "";
		boolean status1 = moduleService.deleteModule(name);
		System.out.println("Module should not be deleted as name is empty and return FALSE, actual result is "+status1);
		Assertions.assertThat(status1).isEqualTo(false);
	}
	
	
	

	
	

}
