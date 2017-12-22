package shaz.com.newyear;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shaz.com.newyear.fragment.SlideShowFragment;

public class SlideShowActivity extends MainActivity implements View.OnClickListener {
    FragmentPagerAdapter adapterViewPager;
    private ViewPager mViewPager;

    private Toolbar mToolbar;
    private ImageView mIvBackIcon;
    private TextView mTvTitleToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMyContentView(R.layout.activity_slide_show);

        mToolbar = findViewById(R.id.toolbar);
        mIvBackIcon = findViewById(R.id.ivBackIcon);
        mTvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        mTvTitleToolbar.setText("Sweet Slideshow");
        mViewPager = findViewById(R.id.viewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);
        mIvBackIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.ivBackIcon) {
            openCloseDrawerLayout();
        }
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 9;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return SlideShowFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return SlideShowFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(2, "Page # 3");

                case 3: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(3, "Page # 3");

                case 4: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(4, "Page # 3");

                case 5: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(5, "Page # 3");

                case 6: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(6, "Page # 3");

                case 7: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(7, "Page # 3");

                case 8: // Fragment # 1 - This will show SecondFragment
                    return SlideShowFragment.newInstance(8, "Page # 3");


                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
