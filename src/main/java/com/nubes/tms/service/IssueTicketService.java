package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Issue;

public interface IssueTicketService {

	Issue issueNewTicket(Issue issue);

	Issue getTicketById(String id);

	List<Issue> getTicketsByModule(String moduleName);

	Issue updateIssue(Issue issue);

	List<Issue> getAllIssues();

	List<Issue> getAllIssuesByStatus(String status);

	List<Issue> getAllIssuesByPriority(String priority);

}
