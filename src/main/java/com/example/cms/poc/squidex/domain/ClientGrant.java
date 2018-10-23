package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
public final class ClientGrant {
    @NonNull
    @JsonProperty("grant_type")
    private final String grantType = "client_credentials";

    @NonNull
    @JsonProperty("client_id")
    private final String clientId;

    @NonNull
    @JsonProperty("client_secret")
    private final String clientSecret;

    @NonNull
    @JsonProperty("scope")
    private final String scope = "squidex-api";

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", grantType);
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        map.put("scope", scope);
        return map;
    }
}
