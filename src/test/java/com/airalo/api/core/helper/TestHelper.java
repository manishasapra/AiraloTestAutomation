package com.airalo.api.core.helper;

import com.airalo.api.core.models.EsimData;
import com.airalo.api.core.models.EsimListResponse;
import com.airalo.api.core.models.EsimOrderResponse;
import com.airalo.api.core.models.Sim;

import java.util.List;

public class TestHelper {

    public List<EsimData> getOrderListExpectedResponse(EsimOrderResponse esimOrderResponse, List<EsimData> esimListExpectedResponse) {

        int generatedId = esimOrderResponse.getData().getId();
        String generatedCode = esimOrderResponse.getData().getCode();
        String generatedCreatedAt = esimOrderResponse.getData().getCreatedAt();
        List<Sim> sims = esimOrderResponse.getData().getSims();

        for (int i = 0; i < sims.size(); i++) {
            esimListExpectedResponse.get(i).setId(sims.get(i).getId());
            esimListExpectedResponse.get(i).setIccId(sims.get(i).getIccId());
            esimListExpectedResponse.get(i).setQrcodeUrl(sims.get(i).getQrCodeUrl());
            esimListExpectedResponse.get(i).setQrcodeUrl(sims.get(i).getQrCodeUrl());
            esimListExpectedResponse.get(i).setCreatedAt(sims.get(i).getCreatedAt());
            esimListExpectedResponse.get(i).getSimable().setId(generatedId);
            esimListExpectedResponse.get(i).getSimable().setCode(generatedCode);
            esimListExpectedResponse.get(i).getSimable().setCreatedAt(generatedCreatedAt);
        }
        return esimListExpectedResponse;
    }

    public List<EsimData> getOrderListActualResponse(EsimOrderResponse esimOrderResponse, EsimListResponse esimListResponse) {
        List<Integer> generatedSimIds = esimOrderResponse.getData().getSims().stream().map(Sim::getId).toList();
        List<EsimData> allSims = esimListResponse.getData();

        return allSims.stream()
                .filter(sim -> generatedSimIds.contains(sim.getId()))
                .toList();
    }
}
