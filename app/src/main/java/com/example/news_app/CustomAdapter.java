package com.example.news_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_app.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListner listner;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines,SelectListner listner) {
        this.context = context;
        this.headlines = headlines;
        this.listner = listner;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_ist_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.OnNewsClicked(headlines.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
