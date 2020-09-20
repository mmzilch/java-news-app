package com.example.newsapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.model.ArticlesItem;
import com.example.newsapp.model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ArticleListAdapter  extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    List<ArticlesItem> articleItems = new ArrayList<ArticlesItem>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        ArticleViewHolder articleViewHolder = new ArticleViewHolder(view);
        return articleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articleItems.get(position).getTitle());
        Picasso.get().load(articleItems.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articleItems.size();
    }

    public void updateArticle(List<ArticlesItem> articleItems){
        this.articleItems = articleItems;
        Log.d("article", articleItems.toString());
        notifyDataSetChanged();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView imageView;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);//super = parent class>>(Recyclerview.viewHolder)

            this.title = itemView.findViewById(R.id.tvTitle);
            this.imageView = itemView.findViewById(R.id.imgNews);

        }
    }
}
