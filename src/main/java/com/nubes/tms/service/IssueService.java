package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;

public interface IssueService {

	Issue createNewIssue(Issue issue);

	Issue getIssueById(String id);

	List<Issue> getIssuesByModule(String moduleName);

	Issue updateIssue(Issue issue);

	List<Issue> getAllIssues();

	List<Issue> getIssuesByStatus(String status);

	List<Issue> getIssuesByPriority(String priority);

	Long deleteAllIssues();

	boolean deleteIssueById(String id);

	Issue updateIssuePriority(String id, Priority priority);

	Issue addComment(String id, Comments comment);

	Issue updateIssueStatus(String id, Status status);
	
	List<Issue> getAllIssuesByOrg(String orgName);
	
	List<Issue> getAllIssuesByEmail(String email);
}
