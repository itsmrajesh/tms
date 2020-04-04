package com.nubes.tms.service;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.exceptions.UserExistsException;

public interface AppUserService {

	AppUser registerUser(AppUser appUser) throws UserExistsException;
  List<AppUser> getAllUsers();
  public AppUser userProfile(String email);


}
