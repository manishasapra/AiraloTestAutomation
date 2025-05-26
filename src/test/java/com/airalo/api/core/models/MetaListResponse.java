package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetaListResponse {

    @SerializedName("message")
    String message;

    @SerializedName("current_page")
    int currentPage;

    @SerializedName("from")
    int from;

    @SerializedName("last_page")
    int lastPage;

    @SerializedName("path")
    String path;

    @SerializedName("per_page")
    String perPage;

    @SerializedName("to")
    int to;

    @SerializedName("total")
    int total;
}
