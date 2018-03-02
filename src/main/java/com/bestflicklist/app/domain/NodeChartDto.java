package com.bestflicklist.app.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
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

  @JsonCreator
  public NodeChartDto(@JsonProperty("id") String id,@JsonProperty("ranking") long ranking, @JsonProperty("user_voted") long userVoted,@JsonProperty("release_date") long releaseDate,@JsonProperty("popularity") long popularity) {
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

  @JsonProperty("genres_ranking")
  public void setGenresRankingList(List<GenresRanking> list){
    genresRankingList.clear();
    genresRankingList.addAll(list);
  }

  @JsonSetter
  public NodeChartDto addGenresRanking(@JsonProperty("genre") Genre genre,@JsonProperty("order") int order){
    genresRankingList.add(new GenresRanking(genre,order));
    return this;
  }



 static private class GenresRanking {

    private final Genre genre;
    private final int order;


    @JsonCreator
    private GenresRanking(@JsonProperty("genre") Genre genre,@JsonProperty("order") int order) {
      this.genre = genre;
      this.order = order;
    }

    public Genre getGenre() {
      return genre;
    }

    public int getOrder() {
      return order;
    }
  }
}

