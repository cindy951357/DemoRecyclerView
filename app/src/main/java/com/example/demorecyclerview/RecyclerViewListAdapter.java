package com.example.demorecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder> {
    /* Nicole taught me that <> contains self-defined class*/

    private static final String TAG = "RecyclerViewListAdapter";
    private static final int repeatTimes = R.integer.repeat_times;

    public RecyclerViewListAdapter(Context context, ArrayList<String> imageNames, ArrayList<Integer> imageIds) {
        mImageNames = imageNames;
        mImageIds = imageIds;
        mContext = context;
    }

    private ArrayList<String> mImageNames = new ArrayList<String>();
    private ArrayList<Integer> mImageIds = new ArrayList<Integer>();
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @NonNull
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder called.");
        /* get element from the dataset at this position */
        Log.d(TAG,mImageIds.get(position).toString());
        holder.imageRabbit.setImageResource(mImageIds.get(position));
        holder.imageName.setText(mImageNames.get(position));
    }

    @Override
    public int getItemCount() {
        int repeatTimes = mContext.getResources().getInteger(R.integer.repeat_times);
        return mImageIds.size()*repeatTimes;/* cannot be zero */
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageRabbit;
        TextView imageName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRabbit = itemView.findViewById(R.id.image_rabbit);
            imageName = itemView.findViewById(R.id.text_img_fname);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
