package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EsimListResponse {

    @SerializedName("data")
    List<EsimData> data;

    @SerializedName("links")
    Links links;

    @SerializedName("meta")
    MetaListResponse meta;
}
