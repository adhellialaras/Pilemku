package com.tupaiaer.cataloguemovie.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tupaiaer.cataloguemovie.util.GlobalVars.BASE_URL;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}