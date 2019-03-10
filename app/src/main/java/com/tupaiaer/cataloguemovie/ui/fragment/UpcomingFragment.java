package com.tupaiaer.cataloguemovie.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tupaiaer.cataloguemovie.R;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class UpcomingFragment extends Fragment {


    public UpcomingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

}
