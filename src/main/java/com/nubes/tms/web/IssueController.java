package com.nubes.tms.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.auth.config.ContextUserUtil;
import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;
import com.nubes.tms.service.IssueService;

@RestController
@RequestMapping("/api/issue/")
public class IssueController {

	private static final Logger Log = LoggerFactory.getLogger(IssueController.class);

	@Autowired
	private IssueService issueTicketService;

	@PostMapping("/new")
	public Issue newIssue(@RequestBody Issue issue) {
		// Log.info("New Issue for module {} ", issue.getModule());
		return issueTicketService.createNewIssue(issue);
	}

	@GetMapping("/all")
	public List<Issue> getAllIssues() {
		return issueTicketService.getAllIssues();
	}

	@GetMapping("{id}")
	public Issue getIssue(@PathVariable String id) {
		// Log.info("Searching for issue with id {} ", id);
		return issueTicketService.getIssueById(id);
	}

	@GetMapping("module/{moduleName}")
	public List<Issue> getAllIssuesByModule(@PathVariable String moduleName) {
		// Log.info("retriving all issues with module name {} ", moduleName);
		return issueTicketService.getIssuesByModule(moduleName);
	}

	@GetMapping("status/{status}")
	public List<Issue> getAllIssuesByStatus(@PathVariable String status) {
		// Log.info("retriving all issues with status {} ", status);
		return issueTicketService.getIssuesByStatus(status);
	}

	@GetMapping("priority/{priority}")
	public List<Issue> getAllIssuesByPriority(@PathVariable String priority) {
		// Log.info("retriving all issues with Priority {} ", priority);
		return issueTicketService.getIssuesByPriority(priority);
	}

	@PutMapping("/update")
	public Issue updateIssue(@RequestBody Issue issue) {
		Log.info("new update request for problem statement {} and status {} ", issue.getProblemStatement(),
				issue.getStatus());
		return issueTicketService.updateIssue(issue);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteIssueById(@PathVariable String id) {
		return issueTicketService.deleteIssueById(id);
	}

	@DeleteMapping("/deleteall")
	public Long deleteAllIssues() {
		return issueTicketService.deleteAllIssues();
	}

	@PutMapping("priority/{id}/{priority}")
	public Issue updatePriority(@PathVariable String id, @PathVariable Priority priority) {
		return issueTicketService.updateIssuePriority(id, priority);
	}

	@PutMapping("addcomment/{id}")
	public Issue addComment(@PathVariable String id, @RequestBody Comments comment) {
		return issueTicketService.addComment(id, comment);
	}

	@PutMapping("status/{id}/{status}")
	public Issue updateIssue(@PathVariable String id, @PathVariable Status status) {
		return issueTicketService.updateIssueStatus(id, status);
	}

	@GetMapping("org/{orgName}")
	public List<Issue> getIssuesByOrg(@PathVariable String orgName) {
		return issueTicketService.getAllIssuesByOrg(orgName);
	}

	@GetMapping("email/{email}")
	public List<Issue> getIssuesByEmail(@PathVariable String email) {
		return issueTicketService.getAllIssuesByEmail(email);
	}

}
