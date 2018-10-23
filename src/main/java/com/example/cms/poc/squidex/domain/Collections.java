package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Collections {
    @NonNull
    private final List<ListedCollection> data;
}
