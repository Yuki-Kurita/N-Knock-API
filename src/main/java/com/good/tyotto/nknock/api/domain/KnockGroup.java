package com.good.tyotto.nknock.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnockGroup {

    private List<Knock> knocks;

    public List<Knock> getKnocks() {
        return knocks;
    }

    public void setKnocks(List<Knock> knocks) {
        this.knocks = knocks;
    }
}
