package com.tupaiaer.cataloguemovie.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tupaiaer.cataloguemovie.model.Movie;
import com.tupaiaer.cataloguemovie.R;
import com.tupaiaer.cataloguemovie.adapter.MoviesAdapter;
import com.tupaiaer.cataloguemovie.model.MoviesResponse;
import com.tupaiaer.cataloguemovie.rest.ApiClient;
import com.tupaiaer.cataloguemovie.rest.ApiInterface;
import com.tupaiaer.cataloguemovie.ui.activity.MainActivity;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tupaiaer.cataloguemovie.util.GlobalVars.API_KEY;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class NowPlayingFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;

    public NowPlayingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        final RecyclerView recyclerView =(RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (API_KEY.isEmpty()) {
            Toast.makeText(getContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse>call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.item_movie, getContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponse>call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
