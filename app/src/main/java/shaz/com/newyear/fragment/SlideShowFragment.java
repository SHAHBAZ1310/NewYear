package shaz.com.newyear.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import shaz.com.newyear.R;
import shaz.com.newyear.customviews.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideShowFragment extends Fragment {


    public SlideShowFragment() {
        // Required empty public constructor
    }

    ImageView imageView;
    private CustomTextView mQuote;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide_show, container, false);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        imageView = (ImageView) view.findViewById(R.id.image);
        mQuote = (CustomTextView)view.findViewById(R.id.quote);
        switch (page) {
            case 0:
                imageView.setBackgroundResource(R.drawable.image1);
                mQuote.setText(getString(R.string.quote_two));
                break;
            case 1:
                imageView.setBackgroundResource(R.drawable.image2);
                mQuote.setText(getString(R.string.quote_four));
                break;

            case 2:
                mQuote.setText(getString(R.string.quote_six));
                imageView.setBackgroundResource(R.drawable.image3);
                break;
            case 3:
                imageView.setBackgroundResource(R.drawable.image4);
                mQuote.setText(getString(R.string.quote_seven));
                break;
            case 4:
                imageView.setBackgroundResource(R.drawable.image5);
                mQuote.setText(getString(R.string.quote_three));
                break;
            case 5:
                imageView.setBackgroundResource(R.drawable.image6);
                mQuote.setText(getString(R.string.quote_five));
                break;
            case 6:
                imageView.setBackgroundResource(R.drawable.image7);
                mQuote.setText(getString(R.string.quote_one));
                break;
            case 7:
                imageView.setBackgroundResource(R.drawable.image8);
                mQuote.setText(getString(R.string.quote_nine));
                break;
            case 8:
                imageView.setBackgroundResource(R.drawable.image9);
                mQuote.setText(getString(R.string.quote_eight));
                break;


            default:
                break;

        }
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