package com.example.ozgur.kadrajdisi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prof.rssparser.Article;

import java.util.ArrayList;

/**
 * Created by ozgur on 24.02.2018.
 */

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private ArrayList<Article> posts;

    public PostRecyclerAdapter(ArrayList<Article> posts) {
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        final Article post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(ArrayList<Article> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public ArrayList<Article> getPosts() {
        return posts;
    }
}
