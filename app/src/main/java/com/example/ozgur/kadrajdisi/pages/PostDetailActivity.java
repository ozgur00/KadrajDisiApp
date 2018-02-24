package com.example.ozgur.kadrajdisi.pages;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ozgur.kadrajdisi.R;
import com.prof.rssparser.Article;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostDetailActivity extends AppCompatActivity {

    private static final String TITLE_KEY = "TITLE";
    private static final String THUMBNAIL_KEY = "THUMBNAIL";
    private static final String DATE_KEY = "DATE";
    private static final String CONTENT_KEY = "CONTENT";

    @BindView(R.id.postdetail_textview_title)
    TextView title;

    @BindView(R.id.postdetail_imageview_thumbnail)
    ImageView thumbnail;

    @BindView(R.id.postdetail_textview_date)
    TextView date;

    @BindView(R.id.postdetail_textview_content)
    TextView content;

    public static Intent newIntent(Context context, Article article) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        intent.putExtra(TITLE_KEY, article.getTitle());
        intent.putExtra(THUMBNAIL_KEY, article.getImage());
        intent.putExtra(DATE_KEY, article.getPubDate().toString());
        intent.putExtra(CONTENT_KEY, article.getContent());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);
        title.setText(getIntent().getStringExtra(TITLE_KEY));
        date.setText(getIntent().getStringExtra(DATE_KEY));
        content.setText(Html.fromHtml(getIntent().getStringExtra(CONTENT_KEY)));
        Picasso.with(this).load(getIntent().getStringExtra(THUMBNAIL_KEY)).into(thumbnail);
    }
}
