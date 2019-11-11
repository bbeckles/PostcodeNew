package com.spartaglobal.postcodeiotestservices.MultiPC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotestservices.MultiPC.MPCDTO.MPCDTO;
import com.spartaglobal.postcodeiotestservices.MultiPC.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotestservices.MultiPC.MPCHttpManagement.MPCResponseManager;

public class MPCService {
    private MPCHttpCallManager mpcHttpCallManager;
    private MPCResponseManager mpcResponseManager;
    private ObjectMapper objectMapper;

    public MPCService() {
        this.mpcHttpCallManager = new MPCHttpCallManager();
        this.mpcResponseManager = new MPCResponseManager();
        this.objectMapper = new ObjectMapper();
    }

    public  void executeMPCPostRequest(String listOfPostcodeSplitByComma){
        mpcResponseManager.setFullResponse(mpcHttpCallManager.executeMultiplePostCodeRequest(listOfPostcodeSplitByComma));
    }

    public MPCDTO getParsedJsonResponse(){
        MPCDTO parsedResponse = null;

        try {
            parsedResponse = objectMapper.readValue(mpcResponseManager.getResponseBody(), MPCDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return parsedResponse;
    }
}
