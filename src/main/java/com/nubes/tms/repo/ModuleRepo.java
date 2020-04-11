package com.nubes.tms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nubes.tms.domain.Module;

public interface ModuleRepo extends MongoRepository<Module, String> {
	
	
	Module findByName(String name);
	Module findByUserName(String user);
	Module deleteByName(String name);

}
