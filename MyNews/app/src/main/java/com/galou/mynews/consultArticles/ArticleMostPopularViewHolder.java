package com.galou.mynews.consultArticles;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.galou.mynews.R;
import com.galou.mynews.models.ArticleMostPopular;
import com.galou.mynews.utils.DateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by galou on 2019-03-30
 */
public class ArticleMostPopularViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.recycler_view_title_article) TextView title;
    @BindView(R.id.recycler_view_date) TextView date;
    @BindView(R.id.recycler_view_section_article) TextView sectionNameView;
    @BindView(R.id.recycler_view_image_article) ImageView imageView;

    public ArticleMostPopularViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithArticles(ArticleMostPopular article, RequestManager glide){
        title.setText(article.getTitle());
        date.setText(DateUtil.convertDateFromAPIToDisplay(article.getPublishedDate()));
        String sectionName = article.getSection();
        String subsection = article.getSubsection();
        if(subsection.length() <= 0 ){
            sectionNameView.setText(sectionName);
        } else {
            sectionNameView.setText(sectionName + " > " + subsection);
        }
        if (article.getMedia().size() > 0){
            String urlMedia = article.getMedia().get(0).getMediaMetadata().get(0).getUrl();
            glide.load(urlMedia).apply(RequestOptions.centerCropTransform()).into(imageView);

        }


    }
}
