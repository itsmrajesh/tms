package com.nubes.tms.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nubes.tms.domain.Issue;

public interface IssueRepo extends MongoRepository<Issue, String> {
	List<Issue> findAllByModule(String moduleName);

	List<Issue> findAllByStatus(String status);

	List<Issue> findAllByPriority(String priority);

	List<Issue> findAllByOrgName(String orgName);

	List<Issue> findAllByCreatedBy(String email);
}
