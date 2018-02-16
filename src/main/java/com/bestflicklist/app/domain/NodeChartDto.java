package com.bestflicklist.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Illia Loshchinin on 16.02.2018.
 */


public class NodeChartDto {

  private final String id;
  private final long ranking;
  @JsonProperty("genres_ranking")
  private final List<GenresRanking> genresRankingList = new ArrayList<>();
  @JsonProperty("user_voted")
  private final long userVoted;
  @JsonProperty("release_date")
  private final long releaseDate;
  private final long popularity;


  public NodeChartDto(String id, long ranking, long userVoted, long releaseDate, long popularity) {
    this.id = id;
    this.ranking = ranking;
    this.userVoted = userVoted;
    this.releaseDate = releaseDate;
    this.popularity = popularity;
  }

  public String getId() {
    return id;
  }

  public long getRanking() {
    return ranking;
  }

  public List<GenresRanking> getGenresRankingList() {
    return genresRankingList;
  }

  public long getUserVoted() {
    return userVoted;
  }

  public long getReleaseDate() {
    return releaseDate;
  }

  public long getPopularity() {
    return popularity;
  }

  public NodeChartDto addGenresRanking(Genre genre, int order){
    genresRankingList.add(new GenresRanking(genre.name().toLowerCase(),order));
    return this;
  }

  private class GenresRanking {

    private final String genre;
    private final int order;

    private GenresRanking(String genre, int order) {
      this.genre = genre;
      this.order = order;
    }

    public String getGenre() {
      return genre;
    }

    public int getOrder() {
      return order;
    }
  }
}

