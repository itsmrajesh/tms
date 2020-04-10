package com.nubes.tms;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.nubes.tms.auth.config.ContextUserUtil;

@Component
public class AppAuditing implements AuditorAware<String> {
	
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(ContextUserUtil.userName());

	}
}
