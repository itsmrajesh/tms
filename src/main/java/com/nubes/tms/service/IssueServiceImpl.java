package com.nubes.tms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.nubes.tms.dao.IssueDao;
import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;
import com.nubes.tms.exceptions.IssueNotFoundException;
import com.nubes.tms.repo.IssueRepo;

@Service
public class IssueServiceImpl implements IssueService {

	private static final Logger log = LoggerFactory.getLogger(IssueServiceImpl.class);

	@Autowired
	private IssueRepo issueRepo;

	@Autowired
	private IssueDao issueDao;

	@Override
	public Issue createNewIssue(Issue issue) {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Issue saveIssue = issueRepo.save(issue);
		if (saveIssue != null) {
			log.info("New issue added with id {} for module {} ", saveIssue.getId(), saveIssue.getModule());
		} else {
			log.error("Issue was unable add");
		}
		return saveIssue;
	}

	@Override
	public Issue getIssueById(String id) throws IssueNotFoundException {
		Assert.notNull(id, "ID Can't be null");
		Optional<Issue> issue = issueRepo.findById(id);
		if (issue.isPresent()) {
			log.info("Found issue by ID {} ", id);
			return issue.get();
		} else {
			log.info("Issue with id {} is not found ", id);
			throw new IssueNotFoundException(String.format("Issue with id %s is not found", id));
		}
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
	public Issue updateIssue(Issue issue) throws IssueNotFoundException {
		Assert.notNull(issue, "Issue object can't null");
		Assert.notNull(issue.getProblemStatement(), "Problem Statement can't be null");
		Assert.notNull(issue.getModule(), "Module Can't be null");
		Assert.notNull(issue.getId(), "ID can't be null for updating");
		Assert.notNull(getIssueById(issue.getId()), "No Issue found with given Ticket ID");
		log.info("Updating issue with problem statement {} and status {} ", issue.getProblemStatement(),
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
	public List<Issue> getIssuesByStatus(Status status) {
		Assert.notNull(status, "status can't be null");
		log.info("Searching all issues with status {} ", status);
		List<Issue> list = issueRepo.findAllByStatus(status);
		log.info("Total issues found for the status {} is {}", status, list.size());
		return list;
	}

	@Override
	public List<Issue> getIssuesByPriority(Priority priority) {
		Assert.notNull(priority, "priority can't be null");
		log.info("Searching all issues with priority {} ", priority);
		List<Issue> list = issueRepo.findAllByPriority(priority);
		log.info("Total issues found for the priority {} is {}", priority, list.size());
		return list;
	}

	@Override
	public Long deleteAllIssues() {
		Long size = issueRepo.count();
		if (size > 0) {
			issueRepo.deleteAll();
			log.info("Deleted {} issues from DB ", size);
		} else {
			log.info("No Issues found in DB to delete");
		}
		return size;
	}

	@Override
	public boolean deleteIssueById(String id) {
		Assert.notNull(id, "Issue ID can't be null");
		if (issueRepo.existsById(id)) {
			issueRepo.deleteById(id);
			log.info("Issue deleted with {} ", id);
			return true;
		}
		log.info("No issue found with ID {} ", id);
		return false;
	}

	@Override
	public Issue updateIssuePriority(String id, Priority priority) throws IssueNotFoundException {
		Assert.notNull(id, "Issue ID cant be null");
		Assert.notNull(priority, "Priority cant be null");
		Issue issue = getIssueById(id);
		if (issue != null) {
			issue = issueDao.updateIssuePriority(id, priority);
			log.info("Priority updated for {} ", id);
		} else {
			log.info("No issue found for updating with ID {} ", id);
		}
		return issue;
	}

	@Override
	public Issue addComment(String id, Comments comment) throws IssueNotFoundException {
		Assert.notNull(id, "ID Cant be null");
		Assert.notNull(comment, "Comment cant be null");
		Issue issue = getIssueById(id);
		if (issue != null) {
			issue = issueDao.addComment(id, comment);
			log.info("comment add by {} for issue with ID {} ", comment.getUserName(), id);
		} else {
			log.info("No issue found for adding comment with ID {} ", id);
		}
		return issue;
	}

	@Override
	public Issue updateIssueStatus(String id, Status status) throws IssueNotFoundException {
		Assert.notNull(id, "ID Cant be null");
		Assert.notNull(status, "Status cant be null");
		Issue issue = getIssueById(id);
		if (issue != null) {
			issue = issueDao.updateIssueStatus(id, status);
			log.info("Issue updated for ID {} with status {} ", id, status);
		} else {
			log.info("No issue found for updating status {} ", id);
		}
		return issue;
	}

	@Override
	public List<Issue> getAllIssuesByOrg(String orgName) {
		Assert.notNull(orgName, "Organization name cant be null");
		List<Issue> list = issueRepo.findAllByOrgName(orgName);
		log.info("Total issues found is {} for Organization: {} ", list.size(), orgName);
		return list;
	}

	@Override
	public List<Issue> getAllIssuesByUserName(String userName) {
		Assert.notNull(userName, "UserName cant be null");
		List<Issue> list = issueRepo.findAllByCreatedBy(userName);
		log.info("Total issues found with email {} is {} ", userName, list.size());
		return list;
	}

}
