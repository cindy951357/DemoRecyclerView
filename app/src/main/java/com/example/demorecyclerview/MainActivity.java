package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static int defaultId = -1;
    private static final String TAG = "MainActivity";
    private int repeatTimes;
    ArrayList<String> mImageNames = new ArrayList<String>();
    ArrayList<Integer> mImageIds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRepeatTimes();
        initImageNamesAndIds();
        initRecyclerViewListAdapter();
    }

    private void initRepeatTimes() {
        repeatTimes = getResources().getInteger(R.integer.repeat_times);
    }

    private void initImageNamesAndIds(){
        Log.d(TAG,"initImageNamesAndIds called");
        TypedArray imgRabbitResourceArr = getResources().obtainTypedArray(R.array.img_rabbit);
        for(int j=0; j<repeatTimes; j++) {
            for (int i = 0; i < imgRabbitResourceArr.length(); i++) {
                int imgId = imgRabbitResourceArr.getResourceId(i, defaultId);
                String imgShortFName = getResources().getResourceEntryName(imgId);
                mImageIds.add(imgId);
                mImageNames.add(imgShortFName);
            }
        }
    }

    private void initRecyclerViewListAdapter(){
        Log.d(TAG,"initRecyclerViewListAdapter called. initiating adapter");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewListAdapter recyclerViewListAdapter = new RecyclerViewListAdapter(this, mImageNames, mImageIds);
        recyclerView.setAdapter(recyclerViewListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

/*Android Official Docs on TypedArray*/
/*
Resources res = getResources();
TypedArray icons = res.obtainTypedArray(R.array.icons);
Drawable drawable = icons.getDrawable(0);

TypedArray colors = res.obtainTypedArray(R.array.colors);
int color = colors.getColor(0,0);
*/
