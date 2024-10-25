package com.marvic.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Person(
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear,
        String name
) {
}
