package com.nubes.tms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubes.tms.reports.service.AppUserReportsService;


@RestController
@RequestMapping("/api/userreports/")
public class AppUserReportsController {
		@Autowired
		private AppUserReportsService appUserReportsService;
		
}
