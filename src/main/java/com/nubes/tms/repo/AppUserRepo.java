package com.nubes.tms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nubes.tms.domain.AppUser;

public interface AppUserRepo extends MongoRepository<AppUser, String> {

}
