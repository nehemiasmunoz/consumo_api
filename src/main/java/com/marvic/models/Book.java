package com.marvic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        String id,
        String title,
        List<Person> authors,
        boolean copyright,
        List<String> subjects,
        @JsonAlias("download_count")
        int downloadCount
) {
}
