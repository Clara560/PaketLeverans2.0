package com.app.services;

import com.app.data.entities.User;
import com.app.data.repositories.UserRepository;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getAuthenticatedUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof Jwt) {
                Jwt jwt = (Jwt) authentication.getPrincipal();

                String keycloakUserId = jwt.getSubject();
                return userRepository.findByKeycloakUserId(keycloakUserId);
            }
        } catch (Exception e) {

        }
        return Optional.empty();
    }
}
