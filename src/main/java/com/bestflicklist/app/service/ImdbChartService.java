package com.bestflicklist.app.service;

import com.bestflicklist.app.domain.Genre;
import com.bestflicklist.app.domain.SortByOption;
import com.bestflicklist.app.domain.dto.MovieDto;
import com.bestflicklist.app.domain.dto.TvShowsDto;
import java.util.List;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * Created by Illia Loshchinin on 16.02.2018.
 */
@Service
public class ImdbChartService implements ChartService {


  @Override
  public List<MovieDto> getMostPopularMovies(@NonNull SortByOption opt,@Nullable Genre... genre) {

    return null;
  }

  @Override
  public List<TvShowsDto> getMostPopularTvShows(@NonNull SortByOption opt,@Nullable Genre... genre) {

    return null;
  }

  @Override
  public List<MovieDto> getTopRatedMovies(@NonNull SortByOption opt,@Nullable Genre... genre) {

    return null;
  }

  @Override
  public List<TvShowsDto> getTopRatedTvShows(@NonNull SortByOption opt,@Nullable Genre... genre) {

    return null;
  }
}
