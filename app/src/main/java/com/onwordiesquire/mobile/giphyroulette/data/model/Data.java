package com.onwordiesquire.mobile.giphyroulette.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michelonwordi on 10/27/16.
 */
@AutoValue
 public abstract class Data {

    @SerializedName("id")
    public abstract String id();

    @SerializedName("image_url")
    public abstract String imageUrl();

    @SerializedName("image_width")
    public abstract String imageWidth();

    @SerializedName("image_height")
    public abstract String imageHeight();

    public static Builder builder() {
        return new AutoValue_Data.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String id);

        public abstract Builder imageUrl(String imageUrl);

        public abstract Builder imageWidth(String width);

        public abstract Builder imageHeight(String height);

        public abstract Data build();

    }

    public static TypeAdapter<Data> typeAdapter(Gson gson) {
        return new AutoValue_Data.GsonTypeAdapter(gson);
    }

}
