package leach.robert.code.challenge;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;



public class ZipCodeReducerTest {



	@Test
	public void testReduceZipCodeRange() {
		ZipRange zipRange[] = { new ZipRange(90000, 90999), 
				new ZipRange(91000, 91999),
				new ZipRange(95825, 95825),
				new ZipRange(96000, 96118),
				new ZipRange(98000, 98999)};
		
		assertArrayEquals("Zip Codes listing does not match", 
				zipRange, 
				ZipCodeReducer.reduceZipCodeRange(Arrays.asList(zipRange)).toArray());

	}
	



}
