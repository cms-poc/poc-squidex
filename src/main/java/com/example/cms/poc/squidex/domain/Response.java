package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Response {
    @NonNull
    private Integer total;

    @NonNull
    private List<Item> items;
}
