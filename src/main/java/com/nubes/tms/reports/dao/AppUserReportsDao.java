package com.nubes.tms.reports.dao;

import java.time.LocalDate;
import java.util.List;

import com.nubes.tms.domain.AppUser;

public interface AppUserReportsDao {
	public List<AppUser> getActiveUsers();
	public List<AppUser> getRegisterdUsers(LocalDate from, LocalDate to);
	public List<AppUser> getUserByOrgname(String orgName);
	public Integer getActiveUsersCount();
	
}
