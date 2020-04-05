package com.nubes.tms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.service.IssueTicketService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/issue/")
public class IssueWebController {

	private static final Logger Log = LoggerFactory.getLogger(IssueWebController.class);

	@Autowired
	private IssueTicketService issueTicketService;

	@PostMapping("/new")
	public Issue newIssue(@RequestBody Issue issue) {
		Log.info("New Issue for module {} ",issue.getModule());
		return issueTicketService.issueNewTicket(issue);
	}

}
