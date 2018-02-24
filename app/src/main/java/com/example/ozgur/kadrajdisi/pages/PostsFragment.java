package com.example.ozgur.kadrajdisi.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ozgur.kadrajdisi.PostRecyclerAdapter;
import com.example.ozgur.kadrajdisi.R;
import com.example.ozgur.kadrajdisi.utils.RssUtil;
import com.example.ozgur.kadrajdisi.utils.ThumbnailUtil;
import com.prof.rssparser.Article;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsFragment extends Fragment {

    private static final String URL_KEY = "URL";

    @BindView(R.id.reviews_recyclerview_posts)
    RecyclerView postsRecyclerView;

    private PostRecyclerAdapter adapter;
    private String url;

    public static PostsFragment newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString(URL_KEY, url);
        PostsFragment fragment = new PostsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString(URL_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);
        adapter = new PostRecyclerAdapter(new ArrayList<Article>());
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        postsRecyclerView.setAdapter(adapter);
        getFeed();
        return view;
    }

    private void getFeed() {
        RssUtil.getArticles(adapter, url);
    }

}
