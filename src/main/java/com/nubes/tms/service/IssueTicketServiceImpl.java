package com.nubes.tms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.repo.IssueRepo;


@Service
public class IssueTicketServiceImpl implements IssueTicketService {

	private static final Logger log = LoggerFactory.getLogger(IssueTicketServiceImpl.class);

	@Autowired
	private IssueRepo issueRepo;

	@Override
	public Issue issueNewTicket(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		log.info("new issue added for module {} ", issue.getModule());
		return issueRepo.save(issue);
	}

	@Override
	public Issue getTicketById(String id) {
		Assert.notNull(id, "ID Can't be null");
		Optional<Issue> issue = issueRepo.findById(id);
		log.info("Finding issue by ID {} ", id);
		return issue.get();
	}

	@Override
	public List<Issue> getTicketsByModule(String moduleName) {
		Assert.notNull(moduleName, "Module Name can't be null");
		log.info("Searching issues by module name {} ", moduleName);
		return issueRepo.findAllByModule(moduleName);
	}

	@Override
	public Issue updateIssue(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Assert.notNull(issue.getId(), "ID can't be null for updating");
		Assert.notNull(getTicketById(issue.getId()), "No Issue found with given Ticket ID");
		log.info("updating issue with problem statement {} and status {} ", issue.getProblemStatement(),
				issue.getStatus());
		return issueRepo.save(issue);
	}

	@Override
	public List<Issue> getAllIssues() {
		log.info("geting all issues");
		return issueRepo.findAll();
	}

	@Override
	public List<Issue> getAllIssuesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllIssuesByPriority(String priority) {
		// TODO Auto-generated method stub
		return null;
	}

}
