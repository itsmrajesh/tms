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
public class IssueServiceImpl implements IssueService {

	private static final Logger log = LoggerFactory.getLogger(IssueServiceImpl.class);

	@Autowired
	private IssueRepo issueRepo;

	@Override
	public Issue createNewIssue(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Issue saveIssue = issueRepo.save(issue);
		if (saveIssue != null) {
			log.info("new issue added with id {} for module {} ", saveIssue.getId(), saveIssue.getModule());
		} else {
			log.error("Issue was unable add");
		}
		return saveIssue;
	}

	@Override
	public Issue getIssueById(String id) {

		Assert.notNull(id, "ID Can't be null");
		Optional<Issue> issue = issueRepo.findById(id);
		if (issue.isPresent()) {
			log.info("Finding issue by ID {} ", id);
		} else {
			log.info("Issue with id {} is not found ", id);
		}
		return issue.get();
	}

	@Override
	public List<Issue> getIssuesByModule(String moduleName) {
		Assert.notNull(moduleName, "Module Name can't be null");
		log.info("Searching issues by module name {} ", moduleName);
		List<Issue> list = issueRepo.findAllByModule(moduleName);
		log.info("Total issues found for the module {} is {}", moduleName, list.size());
		return list;
	}

	@Override
	public Issue updateIssue(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Assert.notNull(issue.getId(), "ID can't be null for updating");
		Assert.notNull(getIssueById(issue.getId()), "No Issue found with given Ticket ID");
		log.info("updating issue with problem statement {} and status {} ", issue.getProblemStatement(),
				issue.getStatus());
		return issueRepo.save(issue);
	}

	@Override
	public List<Issue> getAllIssues() {
		List<Issue> list = issueRepo.findAll();
		log.info("Total issues is {}", list.size());
		return list;
	}

	@Override
	public List<Issue> getIssuesByStatus(String status) {
		Assert.notNull(status, "status can't be null");
		log.info("Searching all issues with status {} ", status);
		List<Issue> list = issueRepo.findAllByStatus(status);
		log.info("Total issues found for the status {} is {}", status, list.size());
		return list;
	}

	@Override
	public List<Issue> getIssuesByPriority(String priority) {
		Assert.notNull(priority, "priority can't be null");
		log.info("Searching all issues with priority {} ", priority);
		List<Issue> list = issueRepo.findAllByPriority(priority);
		log.info("Total issues found for the priority {} is {}", priority, list.size());
		return list;
	}

}
