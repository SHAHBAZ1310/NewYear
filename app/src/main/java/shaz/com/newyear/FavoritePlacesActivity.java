package shaz.com.newyear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import shaz.com.newyear.adapters.DemoListAdapter;

public class FavoritePlacesActivity extends AppCompatActivity implements DemoListAdapter.OnItemClickListener{

    private RecyclerView mRvDemoTabs;
    private GridLayoutManager lLayout;
    private DemoListAdapter demoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_places);
        mRvDemoTabs = findViewById(R.id.rvDemoTabs);
        lLayout = new GridLayoutManager(FavoritePlacesActivity.this, 2);
        mRvDemoTabs.setLayoutManager(lLayout);
        mRvDemoTabs.setHasFixedSize(true);
        demoListAdapter = new DemoListAdapter(this, this,this);
        demoListAdapter.setOnItemClickListener(this);
        mRvDemoTabs.setAdapter(demoListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(FavoritePlacesActivity.this,MapsActivity.class);

        intent.putExtra("rank",position);
        startActivity(intent);
    }
}
