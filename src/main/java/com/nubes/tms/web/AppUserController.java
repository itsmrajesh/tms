package com.nubes.tms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.exceptions.UserExistsException;
import com.nubes.tms.service.AppUserService;

@RestController
@RequestMapping("/api/appuser/")
public class AppUserController {
	private static final Logger log = LoggerFactory.getLogger(AppUserController.class);

	private AppUserService appUserSerivce;

	@Autowired
	public AppUserController(AppUserService appUserService) {
		this.appUserSerivce = appUserService;
	}

	@PostMapping("register")
	public AppUser registerUser(@RequestBody AppUser appUser) throws UserExistsException {
		appUser = this.appUserSerivce.registerUser(appUser);
		log.info("User registred with id:{}", appUser.getId());
		return appUser;
	}

	@GetMapping("{email}")
	public AppUser userProfile(@PathVariable("email") String email) {
		AppUser appUser = this.appUserSerivce.userProfile(email);
		log.info("User profile details- id: {} name:{} email:{} ", appUser.getId(), appUser.getUsername(),
				appUser.getEmail());
		return appUser;
	}
	@PutMapping
	public AppUser updateProfile(@RequestBody AppUser appUser){
		appUser = this.appUserSerivce.updateUser(appUser);
		log.info("User updated with id:{}", appUser.getId());
		return appUser;
	}
	@DeleteMapping("{email}")
	public boolean deleteUser(@PathVariable("email") String email){
		return appUserSerivce.deleteUser(email);
	}

}
