package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataSection {

    @SerializedName("package_id")
    String packageId;

    @SerializedName("quantity")
    String quantity;

    @SerializedName("type")
    String type;

    @SerializedName("description")
    String description;

    @SerializedName("esim_type")
    String esimType;

    @SerializedName("validity")
    int validity;

    @SerializedName("package")
    String packageName;

    @SerializedName("data")
    String dataAmount;

    @SerializedName("price")
    double price;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("id")
    int id;

    @SerializedName("code")
    String code;

    @SerializedName("currency")
    String currency;

    @SerializedName("manual_installation")
    String manualInstallation;

    @SerializedName("qrcode_installation")
    String qrcodeInstallation;

    @SerializedName("installation_guides")
    Map<String, String> installationGuides;

    @SerializedName("brand_settings_name")
    String brandSettingsName;

    @SerializedName("sims")
    List<Sim> sims;
}
