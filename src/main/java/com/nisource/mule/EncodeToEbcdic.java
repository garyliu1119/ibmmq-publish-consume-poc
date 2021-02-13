package com.nisource.mule;

import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodeToEbcdic{
	private static Logger logger = LoggerFactory.getLogger(EncodeToEbcdic.class);
	
    public static void main(String[] args) {
    	
    	String correlationId = "9a400f40-6c13-11eb-9905-005056afd85c";
    	EncodeToEbcdic.encodeToEBCDIC(correlationId);
    }
    
    public static String encodeToEBCDIC(String correlationId)
    {
    	logger.info("correlationId: " + correlationId);
    	
        correlationId = correlationId.substring(0, 24);
        String ebcdicString = null;
        try {
			byte[] byteArray = correlationId.getBytes("CP1047");
			ebcdicString = "ID:" + encodeHexString(byteArray);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info ("EBCDIC: " + ebcdicString);
        
        return ebcdicString;
    }

    
    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
    
    public static String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }    
    
}