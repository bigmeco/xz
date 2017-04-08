package bigi.testretoflistv;

/**
 * Created by bigi on 08.04.2017.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bigi.testretoflistv.POJO.ResultNewF;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private static final String Imeg = "https://image.tmdb.org/t/p/w500";
    private ArrayList<ResultNewF> android;

    public DataAdapter(ArrayList<ResultNewF> android) {
        this.android = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(android.get(i).getTitle());
        viewHolder.tv_version.setText(android.get(i).getOverview());
        viewHolder.tv_api_level.setText(android.get(i).getReleaseDate());
        //viewHolder.imageView.setText(android.get(i).getReleaseDate());
//         ImageView imageView;
//        viewHolder.imageView = (ImageView)view.findViewById(R.id.imageView);
//        Picasso.with()
//                .load(Imeg + android.get(i).getBackdropPath())
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        private ImageView imageView;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);
            imageView = (ImageView)view.findViewById(R.id.imageView);

        }
    }

}