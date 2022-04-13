package com.crm.genericutility;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {

	
		public static int generateRandomNumber(int limit) {
			
			Random ran=new Random();
			int randomNumber=ran.nextInt(limit);
			return randomNumber;
			
		}
		
		/**
		 * 
		 * @return
		 */
		public static String getCurrentDateAndTime()
		{
			SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");//we can change thos format
			Date date=new Date();
			String requiredformat = sdf.format(date);
			return requiredformat;
			//String date=date.toString().replaceAll(":", "_").replaceAll(",", "_"); //instead of this we can use sdf
			
			
		}
		
		/*public static void main(String[] args) {
			System.out.println(requiredformat);
			
		}*/
		
		
		
	

    public static long covertStringtoLong(String timeouts) {
    	
    	long longtimeout = Long.parseLong(timeouts);
    	return longtimeout;
    }
    
}


