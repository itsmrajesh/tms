package com.nubes.tms.service;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.exceptions.UserExistsException;

public interface AppUserService {

	public AppUser registerUser(AppUser appUser) throws UserExistsException;

	public AppUser userProfile(String email);

}
