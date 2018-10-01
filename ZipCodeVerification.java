package leach.robert.code.challenge;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Robert Leach
 * 
 * Verifies that that the Zip Code Range is in proper format.
 */
public class ZipCodeVerification 
{

	public static List<ZipRange> verfiyZipCodeLIsting(String[] zipRangeIn) 
	{
		List<ZipRange> zipRangeList = new ArrayList<ZipRange>();
		
		
		for (String zipRangeString : zipRangeIn) 
		{
			// need to confirm that the zip code listing is actually numbers and in proper format
			if (zipRangeString.matches("\\[[0-9]{5},[0-9]{5}\\]"))
				zipRangeList.add(confirmOrder(zipRangeString));
			else
				
				// skip the current range and throw an error message
				System.err.println("The Zip Code Range of " 
									+ zipRangeString 
									+ " has invalid characters or improper formatting.  Must be in [99999, 99999] format");
		
		}

		return zipRangeList;
	}	
	
	/**
	 * Gets the start and end zip codes from a given input that is in a [00000, 99999] format
	 * to insure proper ordering, the values are evaluated and then swapped if out of order.
	 * 
	 * @param zipListing Input of Zip Code Ranges
	 * @return ZipRange Returns listing of properly formatted AND ordered zip codes
	 */	
	
	private static ZipRange confirmOrder(String zipListing) 
	{

		// remove the brackets from the string
		String[] fullString = zipListing.split("[\\[\\]]");
		// remove the comma
		String zipCodes[] = fullString[1].split(",");
		
		int startingZip = Integer.parseInt(zipCodes[0]);
		int endingZip = Integer.parseInt(zipCodes[1]);
		
		// Make sure the order is valid otherwise reverse them prior to returning ZipRange
		if (startingZip <= endingZip)
		{
			// Zip Code Order is Correct
			return new ZipRange(startingZip, endingZip);
		}
		else
		{
			// Zip code order is reversed
			return new ZipRange(endingZip, startingZip);
		}

	} // end reduceString


	
}  // end ReduceZipCodeListing
 