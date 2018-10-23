package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Collection {
    @NonNull
    @JsonProperty("collection")
    private String name;

    @NonNull
    private Boolean managed;

    @NonNull
    private Boolean hidden;

    @NonNull
    private Boolean single;

    @NonNull
    private String note;

    @NonNull
    private List<Field> fields;

    public Collection() {
        this.name = "";
        this.managed = false;
        this.hidden = false;
        this.single = false;
        this.note = "";
        this.fields = new ArrayList<>();
    }

    public Collection withPrimaryKey(String name) {
        fields.add(new Field(name, "integer", "int", "primary_key", true, true, 10, false));
        return this;
    }

    public Collection withStringField(String name, int length, boolean required, String note) {
        fields.add(new Field(name, "string", "varchar", "text-input", length, required, note));
        return this;
    }
}
