package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;
import com.nubes.tms.exceptions.IssueNotFoundException;

public interface IssueService {

	Issue createNewIssue(Issue issue);

	Issue getIssueById(String id) throws IssueNotFoundException;

	List<Issue> getIssuesByModule(String moduleName);

	Issue updateIssue(Issue issue) throws IssueNotFoundException;

	List<Issue> getAllIssues();

	List<Issue> getIssuesByStatus(Status status);

	List<Issue> getIssuesByPriority(Priority priority);

	Long deleteAllIssues();

	boolean deleteIssueById(String id);

	Issue updateIssuePriority(String id, Priority priority) throws IssueNotFoundException;

	Issue addComment(String id, Comments comment) throws IssueNotFoundException;

	Issue updateIssueStatus(String id, Status status) throws IssueNotFoundException;
	
	List<Issue> getAllIssuesByOrg(String orgName);
	
	List<Issue> getAllIssuesByUserName(String userName);
}
