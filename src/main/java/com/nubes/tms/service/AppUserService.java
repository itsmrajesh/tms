package com.nubes.tms.service;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.exceptions.UserExistsException;

public interface AppUserService {

	AppUser registerUser(AppUser appUser) throws UserExistsException;
    AppUser userProfile(String email);
    AppUser checkUserExists(String email);
    AppUser updateUser(AppUser appUser);
    boolean deleteUser(String email);
    
    

}
