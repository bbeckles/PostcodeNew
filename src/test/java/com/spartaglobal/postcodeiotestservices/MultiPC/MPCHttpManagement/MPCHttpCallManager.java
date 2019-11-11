package com.spartaglobal.postcodeiotestservices.MultiPC.MPCHttpManagement;

import com.spartaglobal.postcodeiotestservices.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.postcodeiotestservices.URLConfig;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class MPCHttpCallManager {

    MPCJsonGenerator mpcJsonGenerator;

    public MPCHttpCallManager() {
        mpcJsonGenerator = new MPCJsonGenerator();
    }

    public CloseableHttpResponse executeMultiplePostCodeRequest(String listOfPostcodesSplitByComma){
        CloseableHttpResponse mpcResponse = null;
        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpPost postMPC = new HttpPost(URLConfig.BASEURL + URLConfig.POSTCODESENDPOINT);
            postMPC.setHeader("Content-Type", "application/json");
            // {"postcodes": ["sw81et","sw99he"]}
            postMPC.setEntity(mpcJsonGenerator.createMPCJsonQuery(listOfPostcodesSplitByComma));
            mpcResponse = closeableHttpClient.execute(postMPC);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mpcResponse;
    }
}
