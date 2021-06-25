package com.rmg.api.generic.utility;

import java.util.List;
import java.util.Random;
/**
 * @author vibhor
 */
public class JavaUtility {

	public String verifyDataInList(List<String> list , String expectedData) {
		String returnData =null;

		for(String actualData:list) {
			if(expectedData.equalsIgnoreCase(actualData)) {
				System.out.println("is ==>"+actualData +" available");
				returnData=actualData;
				break;
			}
		} 
		return returnData;		
	}


	public int getRandomData() {
		Random ran = new Random();
		int randData = ran.nextInt(2000);
		return randData;
	} 

}
