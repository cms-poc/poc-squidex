package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
    @NonNull
    private final String id;

    @NonNull
    private final ItemData data;
}
