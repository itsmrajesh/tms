package com.nubes.tms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.service.IssueTicketService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/issue/")
public class IssueController {

	private static final Logger Log = LoggerFactory.getLogger(IssueController.class);

	@Autowired
	private IssueTicketService issueTicketService;

	@PostMapping("/new")
	public Issue newIssue(@RequestBody Issue issue) {
		Log.info("New Issue for module {} ", issue.getModule());
		return issueTicketService.issueNewTicket(issue);
	}

	@GetMapping("/get/{id}")
	public Issue getIssue(@PathVariable String id) {
		Log.info("Searching for issue with id {} ", id);
		return issueTicketService.getTicketById(id);
	}

	@PostMapping("/update")
	public Issue updateIssue(@RequestBody Issue issue) {
		Log.info("new update request for problem statement {} and status {} ", issue.getProblemStatement(),
				issue.getStatus());
		return issueTicketService.updateIssue(issue);
	}

	@GetMapping("/getallbymodule/{moduleName}")
	public List<Issue> getAllIssuesByModule(@PathVariable String moduleName) {
		Log.info("retriving all issues with module name {} ", moduleName);
		return issueTicketService.getTicketsByModule(moduleName);
	}

}
