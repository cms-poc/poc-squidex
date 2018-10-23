package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.ClientGrant;
import com.example.cms.poc.squidex.domain.ClientToken;
import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenHolder {
    @Value("${squidex.clientId}")
    private String clientId;

    @Value("${squidex.clientSecret}")
    private String clientSecret;

    private final ContentRepository contentRepository;

    private ClientToken clientToken = null;

    public boolean isAuthenticated() {
        return clientToken != null;
    }

    public void authenticate() {
        clientToken = contentRepository.token(new ClientGrant(clientId, clientSecret).toMap());
    }

    public String getAccessToken() {
        return String.format("%s %s", clientToken.getTokenType(), clientToken.getAccessToken());
    }
}
