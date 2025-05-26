package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @SerializedName("id")
    long id;

    @SerializedName("name")
    String name;

    @SerializedName("email")
    String email;

    @SerializedName("mobile")
    String mobile;

    @SerializedName("address")
    String address;

    @SerializedName("state")
    String state;

    @SerializedName("city")
    String city;

    @SerializedName("postal_code")
    String postalCode;

    @SerializedName("country_id")
    int countryId;

    @SerializedName("company")
    String company;

    @SerializedName("created_at")
    String createdAt;
}
