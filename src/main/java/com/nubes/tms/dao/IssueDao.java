package com.nubes.tms.dao;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;

public interface IssueDao {

	Issue updateIssuePriority(String id, Priority priority);

	Issue addComment(String id, Comments comment);

}
