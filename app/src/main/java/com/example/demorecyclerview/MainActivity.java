package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static int defaultId = -1;
    private static final String TAG = "MainActivity";
    ArrayList<String> mImageNames = new ArrayList<String>();;
    ArrayList<Integer> mImageIds = new ArrayList<Integer>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"MainActivity called");
        initImageNamesAndIds();
        initRecyclerViewListAdapter();
        Log.d(TAG,"layout manager is set?");
    }

    private void initImageNamesAndIds(){
        Log.d(TAG,"initImageNamesAndIds called");
        TypedArray imgRabbitResourceArr = getResources().obtainTypedArray(R.array.img_rabbit);
        for(int i=0; i<imgRabbitResourceArr.length(); i++) {
            int imgId = imgRabbitResourceArr.getResourceId(i, defaultId);
            mImageIds.add(imgId);
            mImageNames.add(getResources().getResourceEntryName(imgId));
        }
    }

    private void initRecyclerViewListAdapter(){
        Log.d(TAG,"initRecyclerViewListAdapter called. initiating adapter");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view); /**/
        Log.d(TAG,"01");
        RecyclerViewListAdapter recyclerViewListAdapter = new RecyclerViewListAdapter(this, mImageNames, mImageIds);
        Log.d(TAG,"02");

        recyclerView.setAdapter(recyclerViewListAdapter);
        Log.d(TAG,"03");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG,"04");

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
