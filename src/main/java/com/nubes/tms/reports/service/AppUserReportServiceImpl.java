package com.nubes.tms.reports.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubes.tms.domain.AppUser;
import com.nubes.tms.reports.dao.AppUserReportsDao;
@Service
public class AppUserReportServiceImpl implements AppUserReportsService {
	
	@Autowired
	private AppUserReportsDao appUserReportDao;
	
	@Override
	public List<AppUser> getActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> getRegisterdUsers(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> getUserByOrgname(String orgName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getActiveUsersCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
