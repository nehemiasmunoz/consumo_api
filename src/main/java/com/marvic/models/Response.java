package com.marvic.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record Response(
        int count,
        @JsonAlias("next")
        String nextPage,
        @JsonAlias("previous")
        String previousPage,
        @JsonAlias("results")
        List<Book> books
) {
}
