package com.nubes.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.repo.IssueRepo;

@Service
public class IssueTicketServiceImpl implements IssueTicketService {

	@Autowired
	private IssueRepo issueRepo;

	@Override
	public Issue issueNewTicket(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		return issueRepo.save(issue);
	}

	@Override
	public Issue getTicketById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getTicketsByModule(String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue updateIssue(Issue issue) {
		// TODO Auto-generated method stub
		return null;
	}

}
