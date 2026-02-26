package com.dgw.quizzapp.backend.security;

import static com.dgw.quizzapp.backend.security.SuccessLoginHandler.REFRESH_TOKEN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dgw.quizzapp.backend.exception.RefreshTokenException;
import com.dgw.quizzapp.backend.model.response.RefreshTokenApiResponse;
import com.dgw.quizzapp.backend.repository.IUserRepository;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUserRepository repository;

    @GetMapping("/token/refresh")
    public RefreshTokenApiResponse getRefreshToken(@RequestParam(REFRESH_TOKEN) String refreshToken) {
        var user = repository.findByRefreshToken(refreshToken).orElseThrow(() -> new RefreshTokenException("Refresh token non trouvé"));
        if (user.isRefreshTokenExpired()) {
            throw new RefreshTokenException("Refresh token expired");
        }
        var accessToken = tokenService.createAccessToken(user);
        var newRefreshToken = tokenService.createRefreshToken();
        user.setRefreshToken(newRefreshToken);
        repository.save(user);
        return new RefreshTokenApiResponse(accessToken, newRefreshToken);
    }

}
