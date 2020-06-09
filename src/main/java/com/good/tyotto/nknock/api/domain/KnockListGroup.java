package com.good.tyotto.nknock.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnockListGroup {

    private List<KnockList> knockLists;

    public List<KnockList> getKnockLists() {
        return knockLists;
    }

    public void setKnockLists(List<KnockList> knockLists) {
        this.knockLists = knockLists;
    }
}
