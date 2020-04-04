package com.nubes.tms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/register")
	public AppUser registerUser(@RequestBody AppUser appUser) throws UserExistsException {
		appUser = this.appUserSerivce.registerUser(appUser);
		log.info("User registred with id:{}", appUser.getId());
		return appUser;
	}

	@GetMapping("/profile/{email}")
	public AppUser userProfile(@PathVariable("email") String email) {
		AppUser appUser = this.appUserSerivce.userProfile(email);
		log.info("User profile details- id: {} name:{} email:{} ", appUser.getId(), appUser.getUsername(),
				appUser.getEmail());
		return appUser;

	}
}
