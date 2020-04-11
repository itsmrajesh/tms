package com.nubes.tms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nubes.tms.domain.Module;
import com.nubes.tms.exceptions.ModuleExistsException;
import com.nubes.tms.repo.ModuleRepo;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	private static final Logger log = LoggerFactory.getLogger(Module.class);
	
	@Autowired
	private ModuleRepo moduleRepo;

	@Override
	public Module addModule(Module module) throws ModuleExistsException {
		Assert.notNull(module, "Module cannot be null");
		Assert.notNull(module.getName(), "Module name cannot be null");
		Assert.notNull(module.getUserName(), "Module should have a user allocated");
		
		Module moduleCheck = moduleRepo.findByName(module.getName());
		if(moduleCheck != null) {
			log.info("Module exist with the given module name : {}",moduleCheck.getName());
			throw new ModuleExistsException("Module already exist with the given module name");
		}
		
		module = moduleRepo.save(module);
		log.info("Module added with the name : {} ",module.getName());
		return module;
	}

	@Override
	public Module getModuleByName(String name) {
		Assert.notNull(name, "Name of the module cannot be null");
		Module module =  moduleRepo.findByName(name);
		if(module != null) {
			log.info("Module found with module name : {}",module.getName());
		}
		return module;
	}

	@Override
	public Module getModuleByUsername(String user) {
		Assert.notNull(user, "Username of the module cannot be null");
		Module module =  moduleRepo.findByUserName(user);
		if(module != null) {
			log.info("Module found with module username : {}",module.getUserName());
		}
		return module;
	}

	@Override
	public Module updateModule(Module module,String name) throws ModuleExistsException {
		Assert.notNull(module, "Module cannot be null");
		Assert.notNull(module.getName(), "Module name cannot be null");
		
		Module moduleCheck = moduleRepo.findByName(name);
		if(moduleCheck == null) {
			log.info("Module with module name : {} is not found",module.getName());
		}
		moduleCheck.setName(module.getName());
		moduleCheck.setUserName(module.getUserName());
		moduleCheck.setEmail(module.getEmail());
		module = moduleRepo.save(moduleCheck);
		log.info("Module updated with the name : {} ",module.getName());
		return module;
	}

	
	@Override
	public boolean deleteModule(String name) {
		Assert.notNull(name, "Name of the module cannot be null");
		Module module = moduleRepo.deleteByName(name);
		if (module == null) {
			log.info("User is not found for the given name:{}", name);
			return false;
		}
			log.info("Module with name: {} deleted successfully",name);
		return true;
	}

	@Override
	public List<Module> viewModules() {
		List<Module> list = moduleRepo.findAll();
		if(list.size()==0) {
			log.info("No module records were found");
		}
		return list;
	}

}
