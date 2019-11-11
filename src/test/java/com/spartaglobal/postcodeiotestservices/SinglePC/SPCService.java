package com.spartaglobal.postcodeiotestservices.SinglePC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotestservices.SinglePC.SPCDTO.SPCDTO;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHTTPCallManager;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHttpResponseManager;

public class SPCService {
    private SPCHTTPCallManager spchttpCallManager;
    private SPCHttpResponseManager spcHttpResponseManager;
    private ObjectMapper objectMapper;

    public SPCService() {
        spchttpCallManager = new SPCHTTPCallManager();
        spcHttpResponseManager = new SPCHttpResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeSinglePostcodeCall(String postcode){
        spcHttpResponseManager.setFullResponse(spchttpCallManager.executeSPCGetrequest(postcode));
    }

    public SPCDTO getParsedJSONResponse(){
        SPCDTO parsedRespone = null;
        try {
            parsedRespone =  objectMapper.readValue(spcHttpResponseManager.getResponseBody(), SPCDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       return parsedRespone;
    }
}
