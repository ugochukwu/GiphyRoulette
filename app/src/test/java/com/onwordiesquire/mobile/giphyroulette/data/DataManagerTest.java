package com.onwordiesquire.mobile.giphyroulette.data;

import com.onwordiesquire.mobile.giphyroulette.common.TestDataFactory;
import com.onwordiesquire.mobile.giphyroulette.data.model.Data;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by michelonwordi on 10/27/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Mock
    GiphyApiService mockGiphyApiService;
    DataManager dataManager;

    @Before
    public void setup()
    {
        dataManager = new DataManager(mockGiphyApiService);
    }

    @Test
    public void testGetRandomGifSucceed() throws Exception
    {
        //arrange
        RandomDataModel randomDataModel = TestDataFactory.generateFakeGiphyResult();
        stubGetGiphyRandomData(randomDataModel);
        TestSubscriber<RandomDataModel> testSubscriber = new TestSubscriber<>();
        //act
        dataManager.getRandomGif("2").subscribe(testSubscriber);

        //assert
        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(randomDataModel);
    }

    private OngoingStubbing<Observable<RandomDataModel>> stubGetGiphyRandomData(RandomDataModel randomDataModel) {
        return when(mockGiphyApiService.randomRoulette(anyString())).thenReturn(Observable.just(randomDataModel));
    }
}