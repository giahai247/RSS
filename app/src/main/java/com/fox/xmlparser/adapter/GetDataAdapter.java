package com.fox.xmlparser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fox.xmlparser.R;
import com.fox.xmlparser.WebActivity;
import com.fox.xmlparser.model.News;

import java.util.List;

public class GetDataAdapter extends RecyclerView.Adapter<GetDataAdapter.NewsHolder> {

    public Context context;
    public List<News> news;

    public GetDataAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_news,viewGroup,false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder newsHolder, int i) {
        newsHolder.news = news.get(i);
        newsHolder.tvTitle.setText(newsHolder.news.title);
        newsHolder.tvDescription.setText(newsHolder.news.description);
        //newsHolder.tvPubDate.setText(newsHolder.news.pubDate);
        newsHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("link",newsHolder.news.link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (news == null) ? 0 : news.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPubDate;
        News news;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            //tvPubDate = itemView.findViewById(R.id.tvPubDate);
        }
    }
}
