package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EsimOrderResponse {

    @SerializedName("data")
    DataSection data;

    @SerializedName("meta")
    Meta meta;
}
