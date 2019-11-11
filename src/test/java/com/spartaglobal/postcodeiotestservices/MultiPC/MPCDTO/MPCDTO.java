package com.spartaglobal.postcodeiotestservices.MultiPC.MPCDTO;

import java.util.List;
import java.util.Map;

public class MPCDTO {
    private String status;
    private List<Map<String,Object>> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Map<String, Object>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }
}
