package com.example.alina.goodmeal.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.alina.goodmeal.Interface.ItemClickListener;
import com.example.alina.goodmeal.Model.Favorites;
import com.example.alina.goodmeal.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Динара on 22.11.2017.
 */
class FavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txt_fav_name;// txt_preptime;
    public ImageView img_fav;

    private ItemClickListener itemClickListener;

    public void setTxt_fav_name(TextView txt_fav_name) {
        this.txt_fav_name = txt_fav_name;
    }

    public FavViewHolder(View itemView) {
        super(itemView);
        txt_fav_name = (TextView)itemView.findViewById(R.id.fav_item_name);
        //txt_preptime = (TextView)itemView.findViewById(R.id.fav_item_preptime);

    }

    @Override
    public void onClick(View v) {

    }
}
public class FavAdapter extends RecyclerView.Adapter<FavViewHolder> {

    private List<Favorites> listData = new ArrayList<>();
    private Context context;

    public FavAdapter(List<Favorites> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.fav_layout, parent,false);
        return new FavViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavViewHolder holder, int position) {
        holder.txt_fav_name.setText(listData.get(position).getProductName());
        //holder.txt_preptime.setText(listData.get(position).getPrepTime());

    }

    @Override
    public int getItemCount() {

        return listData.size();
    }
}
