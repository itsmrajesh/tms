package com.nubes.tms.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;

public interface IssueRepo extends MongoRepository<Issue, String> {
	List<Issue> findAllByModule(String moduleName);

	List<Issue> findAllByStatus(Status status);

	List<Issue> findAllByPriority(Priority priority);

	List<Issue> findAllByOrgName(String orgName);

	List<Issue> findAllByCreatedBy(String email);
}
