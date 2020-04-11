package com.nubes.tms.issue.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.service.IssueService;

@SpringBootTest
class IssueServiceTest {

	private List<Issue> list = new ArrayList<>();

	@Autowired
	private IssueService issueService;
	@Autowired
	private SeedData seedData;

	@BeforeEach
	public void init() {
		list = seedData.getSeedData();
		for (Issue issue : list) {
			issueService.createNewIssue(issue);
		}
	}

	@AfterEach
	public void destroy() {
		issueService.deleteAllIssues();
	}

	@Test
	public void testIssues() {
		List<Issue> lst = issueService.getAllIssues();
		System.out.println("Issues size : " + lst.size());
		assertEquals(1, lst.size());
	}

}
