package com.example.ozgur.kadrajdisi;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ozgur.kadrajdisi.utils.ThumbnailUtil;
import com.prof.rssparser.Article;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ozgur on 24.02.2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.post_imageview_thumbnail)
    ImageView thumbnail;

    @BindView(R.id.post_textview_title)
    TextView title;

    @BindView(R.id.post_textview_author)
    TextView author;

    @BindView(R.id.post_textview_preview)
    TextView preview;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Article article) {
        Picasso.with(thumbnail.getContext()).load(article.getImage()).into(thumbnail);
        title.setText(article.getTitle());
        author.setText("by " + article.getAuthor());
        preview.setText(Html.fromHtml(article.getContent()));
    }
}
