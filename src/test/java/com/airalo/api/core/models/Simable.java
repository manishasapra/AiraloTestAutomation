package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Simable {

    @SerializedName("id")
    long id;

    @SerializedName("code")
    String code;

    @SerializedName("package_id")
    String packageId;

    @SerializedName("currency")
    String currency;

    @SerializedName("quantity")
    int quantity;

    @SerializedName("type")
    String type;

    @SerializedName("description")
    String description;

    @SerializedName("esim_type")
    String esimType;

    @SerializedName("validity")
    String validity;

    @SerializedName("package")
    String packageName;

    @SerializedName("data")
    String data;

    @SerializedName("price")
    String price;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("manual_installation")
    String manualInstallation;

    @SerializedName("qrcode_installation")
    String qrcodeInstallation;

    @SerializedName("installation_guides")
    Map<String, String> installationGuides;

    @SerializedName("text")
    String text;

    @SerializedName("voice")
    String voice;

    @SerializedName("net_price")
    double netPrice;

    @SerializedName("status")
    Status status;

    @SerializedName("user")
    User user;
}