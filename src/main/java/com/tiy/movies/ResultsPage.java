package com.tiy.movies;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultsPage {

    @JsonProperty("results")
    List<Movie> movies;

    public ResultsPage() {
    }

    public ResultsPage(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    @Override
    public String toString() {
        return "ResultPage{" +
                "movies=" + movies +
                '}';
    }
}
