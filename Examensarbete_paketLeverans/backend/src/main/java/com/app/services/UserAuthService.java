package com.app.services;

import com.app.data.entities.User;
import com.app.data.repositories.UserRepository;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UserAuthService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getAuthenticatedUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            KeycloakPrincipal<?> keycloakPrincipal = (KeycloakPrincipal<?>) authentication.getPrincipal();
            String keycloakUserId = keycloakPrincipal.getKeycloakSecurityContext().getToken().getSubject();

            return userRepository.findByKeycloakUserId(keycloakUserId);
        } catch (Exception _) {
        }
        return Optional.empty();
    }
}
