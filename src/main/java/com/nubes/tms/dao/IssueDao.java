package com.nubes.tms.dao;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;
import com.nubes.tms.domain.Status;

public interface IssueDao {

	Issue updateIssuePriority(String id, Priority priority);
	
	Issue updateIssueStatus(String id, Status status);

	Issue addComment(String id, Comments comment);

}
