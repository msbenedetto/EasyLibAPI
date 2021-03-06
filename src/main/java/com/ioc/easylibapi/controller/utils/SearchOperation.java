package com.ioc.easylibapi.controller.utils;


import java.util.Arrays;

public enum SearchOperation {
    AND(","),
    ;

    String literal;

    SearchOperation(String literal) {
        this.literal = literal;
    }

    public static SearchOperation of(String literal) throws Exception {
        return Arrays.stream(values())
                .filter(value -> value.getLiteral().equals(literal))
                .findAny()
                .orElseThrow(() -> new Exception(
                        "Internal server error"));
    }

    public String getLiteral() {
        return literal;
    }
}

