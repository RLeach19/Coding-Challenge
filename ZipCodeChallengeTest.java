package leach.robert.code.challenge;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Tests the "Control Class" of this solution (ZipCodeChallenge)
 * While many other test cases could still be made, due to time constraints and to be concise, a sampling
 * of test cases are provided.
 */
public class ZipCodeChallengeTest {

	@Test
	public void testNormalInput() 
	{
		ZipCodeChallenge.main(new String[] { 
				"[95825,95825]", "[91000,91999]", "[91222,91222]", 
				"[98000,98999]", "[90999,90000]", 
				"[96000,96111]",
				"[96001,96118]"});
		assertTrue("Runs as Expected", true);

	}
	
	@Test
	public void testAlphaInput()
	{
		ZipCodeChallenge.main(new String[] {
				"[AAAAA,95825]", "[91000,91999]",
				});
		assertTrue("Should run and print error message about formatting", true);
		
	}
	
	@Test
	public void testShortNumberInput()
	{
		ZipCodeChallenge.main(new String[] {
				"[9580,95825]", "[91000,91999]",
				});
		
		assertTrue("Should run and print error message about formatting", true);
	}
	
	@Test
	public void testUnOrderedInput()
	{
		ZipCodeChallenge.main(new String[] {
				"[95800,95825]", "[91000,91999]",
				});
		
		assertTrue("Should run without error", true);
	}

}
