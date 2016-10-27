package com.onwordiesquire.mobile.giphyroulette.presentation.gifgallery;

import com.onwordiesquire.mobile.giphyroulette.common.TestDataFactory;
import com.onwordiesquire.mobile.giphyroulette.data.DataManager;
import com.onwordiesquire.mobile.giphyroulette.data.model.Meta;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.util.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by michelonwordi on 10/27/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GifPresenterTest {

    @Mock
    DataManager mockDataManager;
    @Mock
    GifView mockGifView;
    GifPresenter presenter;

    @Rule
    public RxSchedulersOverrideRule rule = new RxSchedulersOverrideRule();

    @Before
    public void setup()
    {
        presenter = new GifPresenter(mockDataManager);
        presenter.attachView(mockGifView);
    }

    @After
    public void tearDown()
    {
        presenter.detachView();
    }

    @Test
    public void testLoadGifSucceed() throws Exception{
        //arrange
        RandomDataModel randomDataModel = TestDataFactory.generateFakeGiphyResult();
        stubGetRandomGif(Observable.just(randomDataModel));
        //act
        presenter.loadGif("2342");
        //assert
        verify(mockGifView).showProgressBar(true);
        verify(mockGifView).displayGif(randomDataModel.data());

    }



    @Test
    public void testLoadGifFailed() throws Exception{
        //arrange
        Meta meta = TestDataFactory.generateMeta(500);
        RandomDataModel randomDataModel = TestDataFactory.generateFakeGiphyResult(meta);
        stubGetRandomGif(Observable.just(randomDataModel));

        //act
        presenter.loadGif("3242");

        //assert
        verify(mockGifView,never()).displayGif(any());
        verify(mockGifView).showError(anyString());

    } @Test
    public void testLoadGifFailed2() throws Exception{
        //arrange
        RandomDataModel randomDataModel = TestDataFactory.generateFakeGiphyResult();
        stubGetRandomGif(Observable.error(new Exception()));

        //act
        presenter.loadGif("3242");

        //assert
        verify(mockGifView,never()).displayGif(any());
        verify(mockGifView).showError(anyString());

    }

    public OngoingStubbing<Observable<RandomDataModel>> stubGetRandomGif(Observable<RandomDataModel> value) {
        return when(mockDataManager.getRandomGif(anyString())).thenReturn(value);
    }


}