package com.airalo.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EsimData {

    @SerializedName("id")
    int id;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("iccid")
    String iccId;

    @SerializedName("lpa")
    String lpa;

    @SerializedName("imsis")
    String imsis;

    @SerializedName("matching_id")
    String matchingId;

    @SerializedName("confirmation_code")
    String confirmationCode;

    @SerializedName("qrcode")
    String qrcode;

    @SerializedName("qrcode_url")
    String qrcodeUrl;

    @SerializedName("direct_apple_installation_url")
    String directAppleInstallationUrl;

    @SerializedName("voucher_code")
    String voucherCode;

    @SerializedName("airalo_code")
    String airaloCode;

    @SerializedName("apn_type")
    String apnType;

    @SerializedName("apn_value")
    String apnValue;

    @SerializedName("is_roaming")
    boolean isRoaming;

    @SerializedName("brand_settings_name")
    String brandSettingsName;

    @SerializedName("msisdn")
    String msisdn;

    @SerializedName("apn")
    Apn apn;

    @SerializedName("recycled")
    boolean recycled;

    @SerializedName("recycled_at")
    String recycledAt;

    @SerializedName("simable")
    Simable simable;
}
