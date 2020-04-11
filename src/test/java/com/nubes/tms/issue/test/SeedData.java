package com.nubes.tms.issue.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Priority;

@Component
public class SeedData {

	public List<Issue> getSeedData() {
		List<Issue> list = new ArrayList<>();

		Comments comment = new Comments();

		comment.setDescription("VPN not working");

		List<Comments> commentsList = new ArrayList<>();

		commentsList.add(comment);

		Issue i1 = Issue.builder().problemStatement("VPN is not working").module("IT").priority(Priority.MEDIUM)
				.description("VPN is not working").orgName("I-EXCEED").comments(commentsList).createdBy("Rajesh").build();

		list.add(i1);
		return list;
	}

}
