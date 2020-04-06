package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Issue;

public interface IssueService {

	Issue createNewIssue(Issue issue);

	Issue getIssueById(String id);

	List<Issue> getIssuesByModule(String moduleName);

	Issue updateIssue(Issue issue);

	List<Issue> getAllIssues();

	List<Issue> getIssuesByStatus(String status);

	List<Issue> getIssuesByPriority(String priority);

	Integer deleteAllIssues();

	boolean deleteIssue(String id);

}
