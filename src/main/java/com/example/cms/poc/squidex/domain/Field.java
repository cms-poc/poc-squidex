package com.example.cms.poc.squidex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Field {
    @NonNull
    @JsonProperty("field")
    private String name;

    @NonNull
    private String type;

    @NonNull
    @JsonProperty("datatype")
    private String dataType;

    @NonNull
    @JsonProperty("interface")
    private String interfaceType;

    @JsonProperty("primary_key")
    private Boolean primaryKey;

    @JsonProperty("auto_increment")
    private Boolean autoIncrement;

    @NonNull
    private Integer length;

    private Boolean signed;

    @JsonProperty("readonly")
    private Boolean readOnly;

    @NonNull
    private Boolean required;

    private String note;

    public Field() {
        this.name = "";
        this.type = "";
        this.dataType = "";
        this.interfaceType = "";
        this.length = 0;
    }

    public Field(String name, String type, String dataType, String interfaceType, Boolean primaryKey, Boolean autoIncrement, Integer length, Boolean signed) {
        this.name = name;
        this.type = type;
        this.dataType = dataType;
        this.interfaceType = interfaceType;
        this.primaryKey = primaryKey;
        this.autoIncrement = autoIncrement;
        this.length = length;
        this.signed = signed;
        this.readOnly = false;
        this.required = true;
    }

    public Field(String name, String type, String dataType, String interfaceType, Integer length, Boolean required, String note) {
        this.name = name;
        this.type = type;
        this.dataType = dataType;
        this.interfaceType = interfaceType;
        this.length = length;
        this.readOnly = false;
        this.required = required;
        this.note = note;
    }
}
