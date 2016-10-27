package com.onwordiesquire.mobile.giphyroulette.presentation.gifgallery;

import com.onwordiesquire.mobile.giphyroulette.data.model.Data;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.presentation.MvpView;

/**
 * Created by michelonwordi on 10/27/16.
 */

public interface GifView extends MvpView {
    public void displayGif(Data data);

    void showProgressBar(boolean b);

    void showError(String msg);
}
