package com.example.cms.poc.squidex.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class FormItem {
    @NonNull
    private Integer id;

    @NonNull
    private String name;

    public ItemData toItemData() {
        return new ItemData(new InvariantField<>(id), new InvariantField<>(name));
    }
}
