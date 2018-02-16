package com.bestflicklist.app.service;


import com.bestflicklist.app.domain.Genre;
import com.bestflicklist.app.domain.SortByOption;
import com.bestflicklist.app.domain.dto.MovieDto;
import com.bestflicklist.app.domain.dto.TvShowsDto;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.lang.Nullable;


/**
 * Created by Illia Loshchinin on 16.02.2018.
 */
public interface ChartService {

  List<MovieDto> getMostPopularMovies(@NotNull SortByOption opt,@Nullable Genre... genre);

  List<TvShowsDto> getMostPopularTvShows(@NotNull SortByOption opt,@Nullable Genre... genre);

  List<MovieDto> getTopRatedMovies(@NotNull SortByOption opt,@Nullable Genre... genre);

  List<TvShowsDto> getTopRatedTvShows(@NotNull SortByOption opt,@Nullable Genre... genre);
}
