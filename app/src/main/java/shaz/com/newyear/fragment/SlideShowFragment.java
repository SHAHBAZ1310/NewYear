package shaz.com.newyear.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shaz.com.newyear.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideShowFragment extends Fragment {


    public SlideShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_slide_show, container, false);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        return view;
    }
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SlideShowFragment newInstance(int page, String title) {
        SlideShowFragment fragmentFirst = new SlideShowFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
}
