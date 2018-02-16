package com.bestflicklist.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class ImdbChartsDto {
  @JsonProperty("most_rated")
  private final CategoryChartDto mostRated = new CategoryChartDto();
  @JsonProperty("top")
  private final CategoryChartDto top = new CategoryChartDto();

  public CategoryChartDto getMostRated() {
    return mostRated;
  }

  public CategoryChartDto getTop() {
    return top;
  }



  public class CategoryChartDto {
    @JsonProperty("tv_shows")
    private final List<NodeChartDto> tvShows = new ArrayList<>();
    @JsonProperty("movies")
    private final List<NodeChartDto> movies = new ArrayList<>();

    public List<NodeChartDto> getTvShows() {
      return tvShows;
    }

    public List<NodeChartDto> getMovies() {
      return movies;
    }

  }



}

