package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sim {

    @SerializedName("id")
    int id;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("iccid")
    String iccId;

    @SerializedName("lpa")
    String lpa;

    @SerializedName("imsis")
    String imSis;

    @SerializedName("matching_id")
    String matchingId;

    @SerializedName("qrcode")
    String qrCode;

    @SerializedName("qrcode_url")
    String qrCodeUrl;

    @SerializedName("direct_apple_installation_url")
    String directAppleInstallationUrl;

    @SerializedName("airalo_code")
    String airaloCode;

    @SerializedName("apn_type")
    String apnType;

    @SerializedName("apn_value")
    String apnValue;

    @SerializedName("is_roaming")
    boolean isRoaming;

    @SerializedName("confirmation_code")
    String confirmationCode;
}
