package com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SPCHttpResponseManager {
    private CloseableHttpResponse SPCResponse;

    public void setFullResponse(CloseableHttpResponse response){
        SPCResponse = response;
    }

    public String getResponseBody(){
        String responseBody = null;
        try {
            return EntityUtils.toString(SPCResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  responseBody;
    }
}
