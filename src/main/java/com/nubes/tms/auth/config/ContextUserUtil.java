package com.nubes.tms.auth.config;

import org.springframework.security.core.context.SecurityContextHolder;

public final class ContextUserUtil {
	
		private ContextUserUtil() {
			
		}
		public static String userName() {
			String uname = SecurityContextHolder.getContext().getAuthentication().getName();
			return uname;
		}
}
