package com.school.modules.appCommon.auditing;

import com.school.modules.auth.service.impl.AppUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long>{

    @Override
    public Optional getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {

            return Optional.of(-1L);
        }


        AppUserDetails userDetails = (AppUserDetails) authentication.getPrincipal();

        return Optional.of(userDetails.getId()); // هذا يجب أن يكون Long

    }

}
