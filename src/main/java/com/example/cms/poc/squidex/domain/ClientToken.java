package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ClientToken {
    @NonNull
    @JsonProperty("access_token")
    private String accessToken;

    @NonNull
    @JsonProperty("expires_in")
    private Long expiresIn;

    @NonNull
    @JsonProperty("token_type")
    private String tokenType;
}
