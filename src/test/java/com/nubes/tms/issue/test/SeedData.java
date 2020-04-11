package com.nubes.tms.issue.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubes.tms.domain.Comments;
import com.nubes.tms.domain.Issue;
import com.nubes.tms.domain.Module;
import com.nubes.tms.domain.Priority;

@Component
public class SeedData {
	
	private List<Module> module;


	public List<Issue> getSeedData() {
		List<Issue> list = new ArrayList<>();

		Comments comment = new Comments();

		comment.setDescription("VPN not working");

		List<Comments> commentsList = new ArrayList<>();

		commentsList.add(comment);

		Issue i1 = Issue.builder().problemStatement("VPN is not working").module("IT").priority(Priority.MEDIUM)
				.description("VPN is not working").orgName("I-EXCEED").comments(commentsList).build();

		list.add(i1);
		return list;
	}
	
	public List<Module> loadDataFromModuleFile() throws IOException {

		if (module == null) {
			module = new ArrayList<Module>();
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("Module.json").getFile());
			ObjectMapper objectMapper = new ObjectMapper();
			Module[] retObject = objectMapper.readValue(new FileInputStream(file.getPath()), Module[].class);
			for (Module m : retObject) {
				module.add(m);
			}
		}
		return module;
	}

}
