package com.nubes.tms.reports.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.repo.AppUserRepo;

@SpringBootTest
public class AppUserReportsServiceSpec {
		@Autowired
		private AppUserRepo appUserRepo;
		List<AppUser> list = getUserListFromSeedData();
		@BeforeEach
		public void init() {
			appUserRepo.deleteAll();
			appUserRepo.saveAll(list);
		}
		@AfterEach
		public void destory() {
			appUserRepo.deleteAll();
		}
		private List<AppUser> getUserListFromSeedData() {
			return null;
		}

		@Autowired
		private AppUserReportsService appUserReportsService;
		
		@Test
		public void getActiveUsersList() {
			List<AppUser> list = appUserReportsService.getActiveUsers();
			Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(4);
		}
}
