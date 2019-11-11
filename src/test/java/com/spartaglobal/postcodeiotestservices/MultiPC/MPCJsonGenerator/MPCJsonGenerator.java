package com.spartaglobal.postcodeiotestservices.MultiPC.MPCJsonGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.http.entity.StringEntity;

public class MPCJsonGenerator {
    // {"postcodes": ["sw81et","sw99he"]}

     private ObjectMapper objectMapper = new ObjectMapper();

     public StringEntity createMPCJsonQuery(String listOfPostcodesSplitByComma){
         ArrayNode postcodeArrayNode = objectMapper.createArrayNode();
         String MPCBaseNode = "{\"postcodes\":";
         String closingJsonBracket = "}";

         String[] postCodeArray = listOfPostcodesSplitByComma.split(",");

         for (String postcode: postCodeArray){
             postcodeArrayNode.add(postcode.replaceAll("\\s", ""));
         }
         System.out.println(MPCBaseNode + postcodeArrayNode + closingJsonBracket);
         return new StringEntity(MPCBaseNode + postcodeArrayNode + closingJsonBracket, "UTF-8");
     }
}


