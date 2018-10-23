package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class ItemData {
    @NonNull
    private final InvariantField<Integer> id;

    @NonNull
    private final InvariantField<String> name;
}
