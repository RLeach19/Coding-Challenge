package leach.robert.code.challenge;

import java.util.List;

import leach.robert.code.challenge.ZipRange;
import leach.robert.code.challenge.ZipCodeVerification;

/*
 * @author Robert Leach
 * 
 * 
 * This is the main control class for the Zip Code Challenege that will take in a give zip code range
 * and print out a reduced range of zip codes.
 */

public class ZipCodeChallenge 
{

	public static void main(String[] args) 
	{

		// make sure the listing is actually zip codes and in proper order
		List<ZipRange> simplified = ZipCodeVerification.verfiyZipCodeLIsting(args);
		// Reduce the listing that is now in proper format and order
		simplified = ZipCodeReducer.reduceZipCodeRange(simplified);
		
		System.out.println("FINAL ORDER: ");
		for (int i=0;i<simplified.size();i++);
		{
			System.out.println(simplified);
		}

		
	} // end main


}

