package com.example.ozgur.kadrajdisi.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ozgur.kadrajdisi.PostRecyclerAdapter;
import com.prof.rssparser.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ozgur on 24.02.2018.
 */

public class ThumbnailUtil extends AsyncTask<ArrayList<Article>, Void, ArrayList<String>> {

    private ArrayList<Article> articles;
    private PostRecyclerAdapter adapter;

    public ThumbnailUtil(ArrayList<Article> articles, PostRecyclerAdapter adapter) {
        this.articles = articles;
        this.adapter = adapter;
    }

    @Override
    protected ArrayList<String> doInBackground(ArrayList<Article>... articles) {
        ArrayList<String> postContents = new ArrayList<>();
        ArrayList<Article> tempArticles = articles[0];
        OkHttpClient client = new OkHttpClient();
        for(Article article : tempArticles) {
            Request request = new Request.Builder().url(article.getLink()).build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    postContents.add(response.body().string());
                } else {
                    postContents.add(null);
                }
            } catch (IOException e) {
                Log.i("ThumbnailUtil", "Couldn't get thumbnail.");
            }
        }
        return postContents;
    }

    @Override
    protected void onPostExecute(ArrayList<String> postContents) {
        super.onPostExecute(postContents);
        for(int i = 0; i < postContents.size(); i++) {
            String content = postContents.get(i);
            if(content != null) {
                Document document = Jsoup.parse(content);
                Elements elements = document.getElementsByAttributeValue("property", "og:image");
                Element element;
                if (!elements.isEmpty()) {
                    element = elements.get(0);
                    articles.get(i).setImage(element.attr("content"));
                    Log.i("thumb", element.attr("content"));
                }
            }
        }
        adapter.setPosts(articles);
    }
}
