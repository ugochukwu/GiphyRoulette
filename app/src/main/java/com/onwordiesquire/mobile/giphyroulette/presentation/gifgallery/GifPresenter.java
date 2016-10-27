package com.onwordiesquire.mobile.giphyroulette.presentation.gifgallery;

import com.onwordiesquire.mobile.giphyroulette.data.DataManager;
import com.onwordiesquire.mobile.giphyroulette.presentation.BasePresenter;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by michelonwordi on 10/27/16.
 */

public class GifPresenter extends BasePresenter<GifView> {

    private final DataManager dataManager;
    private CompositeSubscription compositeSubscription;

    @Inject
    public GifPresenter(DataManager dataManager)
    {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(GifView view) {
        super.attachView(view);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeSubscription.clear();
    }

    public void loadGif(String apiKey)
    {
        isViewAttached();
        getMvpView().showProgressBar(true);
        dataManager.getRandomGif(apiKey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(randomDataModel -> {
                    if(randomDataModel!= null && randomDataModel.meta().status() == 200)
                    {
                        return Observable.just(randomDataModel.data());
                    }
                    return Observable.error(new Exception("Could not retrieve Gif"));
                })
                .subscribe(data -> {
                    getMvpView().displayGif(data);
                },e->{
                    getMvpView().showError("An Error Occurred");
                    Timber.e(e.getMessage(),e);
                });
    }
}
