package leach.robert.code.challenge;

/*
 * @author Robert Leach
 * 
 * This is the ZipRange object
 * Implements Comparable so that it can be sorted using the Collections class
 */
public class ZipRange implements Comparable<ZipRange>
{
	private int start	= 0;
	private int end = 0;
	

	public ZipRange(int startIn, int endIn)
	{
		start = startIn;
		end = endIn;
	} //end inner ZipRange
	
	public int getStart()
	{
		return this.start;
	}
	
	public int getEnd()
	{
		return this.end;
	} 

    @Override
	public int compareTo(ZipRange rangeIn) 
    {

		final int PRIOR = -1;
		final int SAME = 0;
		final int AFTER = 1;

		// If the new range is the same as prior then return: 0 
		if (this == rangeIn || this.equals(rangeIn))
			return SAME;
		// the new range falls within the prior range--return: -1
		if (getStart() < rangeIn.getStart() 
				|| (getStart() == rangeIn.getStart() && getEnd() < rangeIn.getEnd()))
			return PRIOR;

		// the new range is NEW--Return: 1
		return AFTER;

	}
	
	@Override
    public String toString() 
    {
		//overriding toString so that it returns values with brackets and commas
        return "[" + getStart() + ", " + getEnd() + "]";
    }

} //end of outer ZipRange

