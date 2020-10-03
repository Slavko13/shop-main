package ru.shop.dbtools.models.user;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    UNKNOWN,
    MALE,
    FEMALE;

    @JsonValue
    public int toValue() {
        return ordinal();
    }


}
