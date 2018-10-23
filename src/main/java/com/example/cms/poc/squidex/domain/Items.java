package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Items {
    @NonNull
    private final List<Item> data;
}
