package leach.robert.code.challenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/*
 * @author Robert Leach
 * 
 * Purpose of this class is to reduce a set of zip codes provided.
 */

public class ZipCodeReducer {

		/**
		 * Reduce the listing of zip codes 
		 * @param zipRange A list of ZipRange objects
		 * @return ZipRange A reduced and merged listing of ZipRange objects
		 * 
		 * Reduces the provided Listing of zip codes by looking at the current range 
		 * and comparing it to the previous range. If the starting zip code is greater than
		 * the previous end point then the range is new, so add it to the reducedRange; however if
		 * the current range is less then call mergeRange to merge the items.
		 *    
		 * 
		 */

		public static List<ZipRange> reduceZipCodeRange(List<ZipRange> zipRange) 
		{
			
			// make sure the listing is proper order before reducing 
			Collections.sort(zipRange);
			ArrayList<ZipRange> reducedRange = new ArrayList<ZipRange>();
			
			for (ZipRange holdRange : zipRange) 
			{

				if (reducedRange.isEmpty())
				{
					// we are at the start so add the first element
					reducedRange.add(holdRange);
				}
				else if (reducedRange.get(reducedRange.size() - 1).getEnd() < holdRange.getStart())
				{
					// new range does not overlap. Add it.
					reducedRange.add(holdRange);
				}
				else if (reducedRange.get(reducedRange.size() - 1).getEnd() < holdRange.getEnd())
					// The current end is greater than the last end, merge them
				{
				    mergeRange(reducedRange, holdRange);
				}
				// should be noted that if the current start and end are within the previous, don't add the current range
			}

			return reducedRange;
		}


		private static void mergeRange(ArrayList<ZipRange> reducedRange, ZipRange holdRange) 
		{

			ZipRange last = reducedRange.remove(reducedRange.size() - 1);
			reducedRange.add(new ZipRange(last.getStart(), holdRange.getEnd()));
		}

	}
