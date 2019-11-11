package com.spartaglobal.PostcodeNew;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.postcodeiotestservices.MultiPC.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotestservices.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.postcodeiotestservices.MultiPC.MPCService;
import com.spartaglobal.postcodeiotestservices.SinglePC.SPCService;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHTTPCallManager;
import com.spartaglobal.postcodeiotestservices.SinglePC.SinglePCHTTPManager.SPCHttpResponseManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static SPCHTTPCallManager spchttpCallManager;
    private static SPCHttpResponseManager spcHttpResponseManager;

    private static SPCService spcService;
   private static MPCService mpcService;
   private static Map<String,Object> firstResponse;


    @BeforeClass

    public static void setup(){
//       spcService = new SPCService();
//       spcService.executeSinglePostcodeCall("sw99he");
        mpcService = new MPCService();
        mpcService.executeMPCPostRequest("sw9 9he, sw8 1et");
        firstResponse = mpcService.getParsedJsonResponse().getResult().get(0);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
//        Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
//        Assert.assertEquals("sw99he", spcService.getParsedJSONResponse().getResult().get("postcode"));
//        mpcJsonGenerator.createMPCJsonQuery("sw9 9he, SW8 1ET");
        System.out.println(mpcService.getParsedJsonResponse().getStatus());


    }
}
