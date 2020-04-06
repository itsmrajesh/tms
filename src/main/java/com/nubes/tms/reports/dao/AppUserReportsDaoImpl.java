package com.nubes.tms.reports.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.nubes.tms.domain.AppUser;

@Repository
public class AppUserReportsDaoImpl implements AppUserReportsDao {
	
	@Autowired
	private MongoOperations mongoOperations;
	
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
