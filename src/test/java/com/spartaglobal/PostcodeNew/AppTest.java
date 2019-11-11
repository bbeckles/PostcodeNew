package com.spartaglobal.PostcodeNew;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.postcodeiotestservices.SinglePC.SPCService;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHTTPCallManager;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHttpResponseManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static SPCHTTPCallManager spchttpCallManager;
    private static SPCHttpResponseManager spcHttpResponseManager;

    private static SPCService spcService;

    @BeforeClass

    public static void setup(){
       spcService = new SPCService();
       spcService.executeSinglePostcodeCall("sw99he");

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
        Assert.assertEquals("sw99he", spcService.getParsedJSONResponse().getResult().get("postcode"));


    }
}
