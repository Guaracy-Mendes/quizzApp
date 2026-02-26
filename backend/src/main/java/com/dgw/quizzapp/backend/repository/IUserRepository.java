package com.dgw.quizzapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Repository;

import com.dgw.quizzapp.backend.exception.UserNotFoundException;
import com.dgw.quizzapp.backend.model.entity.UserEntity;

import static com.dgw.quizzapp.backend.security.TokenService.JWT_EMAIL_CLAIM_NAME;
import static com.dgw.quizzapp.backend.security.TokenService.JWT_PROVIDER_CLAIM_NAME;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmailAndProvider(String email, String provider);

    default UserEntity findByAccessToken(OAuth2AuthenticationToken token) {
        var email = (String) token.getPrincipal().getAttribute(JWT_EMAIL_CLAIM_NAME);
        var provider = (String) token.getPrincipal().getAttribute(JWT_PROVIDER_CLAIM_NAME);
        return findByEmailAndProvider(email, provider).orElseThrow(() -> new UserNotFoundException(email, provider));
    }

    Optional<UserEntity> findByRefreshToken(String refreshToken);

}
