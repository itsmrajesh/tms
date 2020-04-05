package com.nubes.tms.service;

import java.util.List;
import java.util.Optional;

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
		Assert.notNull(id, "ID Can't be null");
		Optional<Issue> issue = issueRepo.findById(id);
		return issue.get();
	}

	@Override
	public List<Issue> getTicketsByModule(String moduleName) {
		Assert.notNull(moduleName, "Module Name can't be null");
		return issueRepo.findAllByModule(moduleName);
	}

	@Override
	public Issue updateIssue(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Assert.notNull(issue.getId(), "ID can't be null for updating");
		Assert.notNull(getTicketById(issue.getId()), "No Issue found with given Ticket ID");
		return issueRepo.save(issue);
	}

}
