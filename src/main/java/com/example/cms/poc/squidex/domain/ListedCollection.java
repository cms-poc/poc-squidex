package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class ListedCollection {
    @NonNull
    @JsonProperty("collection")
    private final String name;

    private final boolean managed;
}
