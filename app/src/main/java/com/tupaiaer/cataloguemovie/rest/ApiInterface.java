package com.tupaiaer.cataloguemovie.rest;

import com.tupaiaer.cataloguemovie.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public interface ApiInterface {
    @POST("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}