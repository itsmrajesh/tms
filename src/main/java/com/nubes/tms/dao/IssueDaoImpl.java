package com.nubes.tms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;

@Repository
public class IssueDaoImpl implements IssueDao {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Issue updateIssuePriority(String id, Priority priority) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("priority", priority);
		mongoOperations.upsert(query, update, Issue.class);
		Issue issue = mongoOperations.findOne(query, Issue.class);
		return issue;
	}

	@Override
	public Issue addComment(String id, Comments comment) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.push("comments", comment);
		mongoOperations.upsert(query, update, Issue.class);
		Issue issue = mongoOperations.findOne(query, Issue.class);
		return issue;
	}

	@Override
	public Issue updateIssueStatus(String id, Status status) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("status", status);
		mongoOperations.upsert(query, update, Issue.class);
		Issue issue = mongoOperations.findOne(query, Issue.class);
		return issue;
	}

}
