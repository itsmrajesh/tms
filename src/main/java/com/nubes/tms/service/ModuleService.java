package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Module;
import com.nubes.tms.exceptions.ModuleExistsException;

public interface ModuleService {
	
	Module addModule(Module module) throws ModuleExistsException;
	List<Module> viewModules();
	Module getModuleByName(String name);
	Module getModuleByUsername(String user);
	Module updateModule(Module module,String name) throws ModuleExistsException;
	boolean deleteModule(String name);
	
	

}
