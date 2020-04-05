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

	@GetMapping("/get")
	public List<Issue> getAllIssues() {
		Log.info("get all issues");
		return issueTicketService.getAllIssues();
	}

	@GetMapping("/get/{id}")
	public Issue getIssue(@PathVariable String id) {
		Log.info("Searching for issue with id {} ", id);
		return issueTicketService.getTicketById(id);
	}

	@GetMapping("/get/bymodule/{moduleName}")
	public List<Issue> getAllIssuesByModule(@PathVariable String moduleName) {
		Log.info("retriving all issues with module name {} ", moduleName);
		return issueTicketService.getAllIssuesByModule(moduleName);
	}

	@GetMapping("/get/bystatus/{status}")
	public List<Issue> getAllIssuesByStatus(@PathVariable String status) {
		Log.info("retriving all issues with status  {} ", status);
		return issueTicketService.getAllIssuesByStatus(status);
	}

	@GetMapping("/get/bypriority/{priority}")
	public List<Issue> getAllIssuesByPriority(@PathVariable String priority) {
		Log.info("retriving all issues with Priority  {} ", priority);
		return issueTicketService.getAllIssuesByPriority(priority);
	}

	@PostMapping("/update")
	public Issue updateIssue(@RequestBody Issue issue) {
		Log.info("new update request for problem statement {} and status {} ", issue.getProblemStatement(),
				issue.getStatus());
		return issueTicketService.updateIssue(issue);
	}

}
