package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
class Links {

    @SerializedName("first")
    String first;

    @SerializedName("last")
    String last;

    @SerializedName("prev")
    String prev;

    @SerializedName("next")
    String next;
}
