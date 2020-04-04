package com.nubes.tms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nubes.tms.domain.Issue;

public interface IssueRepo extends MongoRepository<Issue, String> {

}
