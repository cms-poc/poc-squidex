package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
    @NonNull
    @JsonProperty("id")
    private String id;

    @NonNull
    private ItemData data;
}
