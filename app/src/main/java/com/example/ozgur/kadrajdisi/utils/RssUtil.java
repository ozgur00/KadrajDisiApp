package com.example.ozgur.kadrajdisi.utils;

import android.widget.Toast;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;

/**
 * Created by ozgur on 23.02.2018.
 */

public class RssUtil {

    public ArrayList<Article> getArticles(String url) {
        Parser parser = new Parser();
        parser.execute(url);
        final ArrayList<Article> articles = new ArrayList<>();
        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                articles.addAll(list);
            }

            @Override
            public void onError() {
            }
        });
        return articles;
    }

}
