package com.bekaku.api.spring.service;

import com.bekaku.api.spring.dto.AccessTokenDto;
import com.bekaku.api.spring.model.AccessToken;
import com.bekaku.api.spring.model.ApiClient;
import com.bekaku.api.spring.model.User;
import com.bekaku.api.spring.model.LoginLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AccessTokenService extends BaseService<AccessToken, AccessToken> {

    List<String> findAllFcmTokenByUserId(Long userId);
    List<AccessToken> findAllByFcmToken(String fcmToken);
    Optional<AccessToken> findByToken(String token);

    Optional<AccessToken> findAccessTokenByToken(String token, boolean revoked);

    AccessToken generateRefreshToken(User user, ApiClient apiClient,  LoginLog loginLog, String fcmToken);

    List<AccessTokenDto> findAllByUserAndRevoked(Long userId, boolean revoked);

    void validateRefreshToken(String token);

    void deleteRefreshToken(String token);

    void revokeTokenByUserId(Long userId);

    void updateNullFcmToken(String fcmToken);

    Optional<AccessToken> findByTokenAndRevoked(String token, boolean revoked);

    void updateLastestActive(LocalDateTime lastestActive, Long id);
}
