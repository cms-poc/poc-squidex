package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class InvariantField<T> {
    @NonNull
    private final T iv;
}
