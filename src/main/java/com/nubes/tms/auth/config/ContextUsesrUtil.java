package com.nubes.tms.auth.config;

import org.springframework.security.core.context.SecurityContextHolder;

public final class ContextUsesrUtil {
	
		private ContextUsesrUtil() {
			
		}
		public static String userName() {
			String uname = SecurityContextHolder.getContext().getAuthentication().getName();
			return uname;
		}
}
