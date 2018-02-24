package com.example.ozgur.kadrajdisi.utils;

import android.util.Log;

import com.example.ozgur.kadrajdisi.PostRecyclerAdapter;
import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;

/**
 * Created by ozgur on 24.02.2018.
 */

public class RssCallback implements Parser.OnTaskCompleted {

    private PostRecyclerAdapter adapter;

    public RssCallback(PostRecyclerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onTaskCompleted(ArrayList<Article> list) {
        new ThumbnailUtil(list, adapter).execute(list);
    }

    @Override
    public void onError() {
        Log.i("error", "rrrr");
    }

}
