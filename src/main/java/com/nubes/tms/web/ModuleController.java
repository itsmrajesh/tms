package com.nubes.tms.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.domain.Module;
import com.nubes.tms.exceptions.ModuleExistsException;
import com.nubes.tms.service.ModuleService;

@RestController
@RequestMapping("/api/module/")
public class ModuleController {
	
	private static final Logger log = LoggerFactory.getLogger(ModuleController.class);
	
	private ModuleService moduleService;
	
	@Autowired
	public ModuleController(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	@PostMapping("/addmodule")
	public Module addModule(@RequestBody Module module) throws ModuleExistsException{
		module = this.moduleService.addModule(module);
		log.info("Module added with name :{} ",module.getName());
		return module;
	}
	
	@GetMapping("/modulebyname/{name}")
	public Module getModuleByName(@PathVariable("name") String name) {
		Module module = this.moduleService.getModuleByName(name);
		log.info("Module details- id: {} name:{} userName:{} email:{} ", module.getId(), module.getName(), module.getUserName(), module.getEmail());
		return module;
		}
	
	@GetMapping("/modulebyuser/{user}")
	public Module getModuleByUser(@PathVariable("user") String user) {
		Module module = this.moduleService.getModuleByUsername(user);
		log.info("Module details- id: {} name:{} userName:{} email:{} ", module.getId(), module.getName(), module.getUserName(), module.getEmail());
		return module;
		}
	
	@GetMapping("/getmodules")
	public List<Module> getModuleByName() {
		List<Module> list = this.moduleService.viewModules();
		return list;
		}
	
	
	@PutMapping("/updatemodule/{name}")
    public Module updateModule(@RequestBody Module module, @PathVariable String name) throws ModuleExistsException {
        module = this.moduleService.updateModule(module,name);
        log.info("Module updated with name :{} ",module.getName());
        return module;
    }


	@DeleteMapping("/deletemodule/{name}")
    public boolean deleteModule(@PathVariable String name) {
		boolean status = this.moduleService.deleteModule(name);
	   log.info("Module with name: {} deleted successfully",name);
	return status;
    }

}
