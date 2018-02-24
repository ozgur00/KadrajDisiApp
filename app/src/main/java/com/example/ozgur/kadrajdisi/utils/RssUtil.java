package com.example.ozgur.kadrajdisi.utils;

import com.example.ozgur.kadrajdisi.PostRecyclerAdapter;
import com.prof.rssparser.Parser;

/**
 * Created by ozgur on 23.02.2018.
 */

public final class RssUtil {

    public static void getArticles(PostRecyclerAdapter adapter, String url) {
        Parser parser = new Parser();
        RssCallback callback = new RssCallback(adapter);
        parser.execute(url);
        parser.onFinish(callback);
    }

}
