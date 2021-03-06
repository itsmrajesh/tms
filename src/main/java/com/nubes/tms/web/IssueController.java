package com.nubes.tms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;
import com.nubes.tms.exceptions.IssueNotFoundException;
import com.nubes.tms.service.IssueService;

@RestController
@RequestMapping("/api/issue/")
public class IssueController {

	@Autowired
	private IssueService issueTicketService;

	@PostMapping("/new")
	public Issue newIssue(@RequestBody Issue issue) {
		return issueTicketService.createNewIssue(issue);
	}

	@GetMapping("/all")
	public List<Issue> getAllIssues() {
		return issueTicketService.getAllIssues();
	}

	@GetMapping("{id}")
	public Issue getIssue(@PathVariable String id) throws IssueNotFoundException {
		return issueTicketService.getIssueById(id);
	}

	@GetMapping("module/{moduleName}")
	public List<Issue> getIssuesByModule(@PathVariable String moduleName) {
		return issueTicketService.getIssuesByModule(moduleName);
	}

	@GetMapping("status/{status}")
	public List<Issue> getIssuesByStatus(@PathVariable Status status) {
		return issueTicketService.getIssuesByStatus(status);
	}

	@GetMapping("priority/{priority}")
	public List<Issue> getIssuesByPriority(@PathVariable Priority priority) {
		return issueTicketService.getIssuesByPriority(priority);
	}

	@PutMapping("/update")
	public Issue updateIssue(@RequestBody Issue issue) throws IssueNotFoundException {
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
	public Issue updatePriority(@PathVariable String id, @PathVariable Priority priority) throws IssueNotFoundException {
		return issueTicketService.updateIssuePriority(id, priority);
	}

	@PutMapping("addcomment/{id}")
	public Issue addComment(@PathVariable String id, @RequestBody Comments comment) throws IssueNotFoundException {
		return issueTicketService.addComment(id, comment);
	}

	@PutMapping("status/{id}/{status}")
	public Issue updateStatus(@PathVariable String id, @PathVariable Status status) throws IssueNotFoundException {
		return issueTicketService.updateIssueStatus(id, status);
	}

	@GetMapping("org/{orgname}")
	public List<Issue> getIssuesByOrg(@PathVariable("orgname") String orgName) {
		return issueTicketService.getAllIssuesByOrg(orgName);
	}

	@GetMapping("username/{username}")
	public List<Issue> getIssuesByEmail(@PathVariable("username") String userName) {
		return issueTicketService.getAllIssuesByUserName(userName);
	}

}
