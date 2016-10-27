package com.onwordiesquire.mobile.giphyroulette.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michelonwordi on 10/27/16.
 */
@AutoValue
public abstract class Meta {


    @SerializedName("status")
   public abstract Integer status();

    @SerializedName("msg")
    public abstract String msg();

    @SerializedName("response_id")
    public abstract String responseId();

    public static Builder builder()
    {
        return new AutoValue_Meta.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder status(Integer status);

        public abstract Builder msg(String msg);

        public abstract Builder responseId(String responseId);
        public abstract Meta build();
    }

    public static TypeAdapter<Meta> typeAdapter(Gson gson)
    {
        return new AutoValue_Meta.GsonTypeAdapter(gson);
    }


}
