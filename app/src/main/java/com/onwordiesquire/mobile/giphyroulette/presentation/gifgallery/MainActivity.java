package com.onwordiesquire.mobile.giphyroulette.presentation.gifgallery;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.onwordiesquire.mobile.giphyroulette.BuildConfig;
import com.onwordiesquire.mobile.giphyroulette.GiphyApp;
import com.onwordiesquire.mobile.giphyroulette.R;
import com.onwordiesquire.mobile.giphyroulette.data.model.Data;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.presentation.MvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements GifView {

    @BindView(R.id.imageview)
    ImageView imageView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    GifPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GiphyApp.get().getComponent().inject(this);
        ButterKnife.bind(this);

        presenter.attachView(this);
        presenter.loadGif(BuildConfig.BETA_KEY);

        setupToolbar();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.refresh)
        {
            presenter.loadGif(BuildConfig.BETA_KEY);
        }
        return true;
    }

    @Override
    public void displayGif(Data data) {
        Timber.i("Image Url is %s", data.imageUrl());
        Glide.with(this)
                .load(String.format(data.imageUrl() + "?api_key=%s", BuildConfig.BETA_KEY))
                .placeholder(R.mipmap.ic_giphy_launcher)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(new GlideDrawableImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                        super.onResourceReady(resource, animation);
                        showProgressBar(false);
                    }
                });
    }

    @Override
    public void showProgressBar(boolean b) {
        if (b) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showError(String msg) {

    }
}
