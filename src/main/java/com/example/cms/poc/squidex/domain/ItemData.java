package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class ItemData {
    @NonNull
    private final Integer id;

    @NonNull
    private final String name;
}
