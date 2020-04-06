package com.nubes.tms.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.exceptions.UserExistsException;
import com.nubes.tms.repo.AppUserRepo;

import javax.validation.constraints.Email;

@Service
public class AppUserServiceImpl implements AppUserService {

	private static final Logger log = LoggerFactory.getLogger(AppUser.class);

	@Autowired
	private AppUserRepo appUserRepo;

	@Override
	public AppUser registerUser(AppUser appUser) throws UserExistsException {

		Assert.notNull(appUser, "Register user object can't null");
		Assert.notNull(appUser.getUsername(), "Register User name can't be empty or null");
		Assert.notNull(appUser.getEmail(), "Register email can't be empty or null");

		AppUser registeredUser = appUserRepo.findByUsername(appUser.getUsername());

		if (registredUser != null) {
			log.info("User exists with the given user name :{}", registeredUser.getUsername());
			throw new UserExistsException("User already exists with user name");
		}
		appUser = appUserRepo.save(appUser);
		log.info("User registered with id:{}", appUser.getId());
		return appUser;
	}

	@Override
	public AppUser userProfile(String email) {
		Assert.notNull(email, "Email can't be null or empty");
		AppUser appUser = appUserRepo.findByEmail(email);
		if (appUser != null) {
			log.info("User is found for the given email:{} and id:{}", email, appUser.getId());
		}
		return appUser;

	}

	@Override
	public 	AppUser checkUserExists(String email) {
		Assert.notNull(email, "Email can't be empty or null");
		AppUser appUser = appUserRepo.findByEmail(email);
		log.info("Searching all users with email {} ", email);
		if (appUser == null) {
			log.info("User is not found for the given email:{}", email);
		}
		return appUser;
	}

	@Override
	public AppUser updateUser(AppUser appUser) {
		Assert.notNull(appUser, "Register user object can't null");
		Assert.notNull(appUser.getUsername(), "Register User name can't be empty or null");
		Assert.notNull(appUser.getEmail(), "Register email can't be empty or null");
		Assert.notNull(appUser.getId(), "No User found with given ID");
		log.info("updating user with username{} and Email{} ", appUser.getUsername(),appUser.getEmail());
		return appUserRepo.save(appUser);
	}

	@Override
	public boolean deleteUser(String email) {
		Assert.notNull(email, "email can't be empty or null");
		appUserRepo.deleteByEmail(email);
		return false;
		log.info("Module with email {} deleted successfully",email);
	}

}
