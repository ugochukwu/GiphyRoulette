package com.onwordiesquire.mobile.giphyroulette.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michelonwordi on 10/27/16.
 */
@AutoValue
public abstract class RandomDataModel {

    @SerializedName("data")
    public abstract Data data();
    @SerializedName("meta")
    public abstract Meta meta();

    public static Builder builder()
    {
        return new AutoValue_RandomDataModel.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder data(Data data);
        public abstract Builder meta(Meta meta);
        public abstract RandomDataModel build();
    }

    public static TypeAdapter<RandomDataModel> typeAdapter(Gson gson)
    {
        return new AutoValue_RandomDataModel.GsonTypeAdapter(gson);
    }
}
