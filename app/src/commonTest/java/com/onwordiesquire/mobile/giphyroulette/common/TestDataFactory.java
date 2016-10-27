package com.onwordiesquire.mobile.giphyroulette.common;

import com.onwordiesquire.mobile.giphyroulette.data.model.Data;
import com.onwordiesquire.mobile.giphyroulette.data.model.Meta;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;

/**
 * Created by michelonwordi on 10/24/16.
 */

public class TestDataFactory {

    public static RandomDataModel generateFakeGiphyResult() {
        Data data = generateFakeGifData();
        Meta meta = generateMeta(200);
        RandomDataModel randomDataModel = RandomDataModel.builder()
                .data(data)
                .meta(meta)
                .build();

        return randomDataModel;
    }

    public static RandomDataModel generateFakeGiphyResult(Meta meta) {
        Data data = generateFakeGifData();
        RandomDataModel randomDataModel = RandomDataModel.builder()
                .data(data)
                .meta(meta)
                .build();

        return randomDataModel;
    }

    public static Meta generateMeta(Integer status) {
        return Meta.builder()
                    .msg("OK")
                    .status(status)
                    .responseId("5811dc4ebeb99319f6ccc678")
                    .build();
    }

    public static Data generateFakeGifData() {
        return Data.builder().
                    id("1")
                    .imageHeight("500")
                    .imageWidth("600")
                    .imageUrl("http://media1.giphy.com/media/3o8dp6Dl2MxYX082JO/giphy.gif")
                    .build();
    }


}
