package com.nubes.tms.service;

import java.util.List;

import com.nubes.tms.domain.Issue;

public interface IssueTicketService {

	Issue issueNewTicket(Issue issue);

	Issue getTicketById(String id);

	List<Issue> getTicketsByModule(String moduleName);
	
	

}
