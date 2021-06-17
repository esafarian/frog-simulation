public class FrogSimulation
{
	private int goalDistance;
	private int maxHops;
	
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	public FrogSimulation(int dist, int numHops)
	{
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;
	}

	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public boolean simulate(){ 
	
		int distance = 0;
		int hops = 0;
		
		for(int x = 0; distance < goalDistance && hops < maxHops; x++) {
			
			int temp = hopDistance();
			
			distance = distance + temp;
			hops++;
			
		if(distance< 0) {
			return false;
			}
		}
		
		boolean x = false;
		if(distance >= goalDistance)
			x = true;
		
		return x;
	}
	
	public double runSimulations(int num){ 
		double result = 0;
		int count = 0;
		int trueCount = 0;
		int falseCount = 0;
		
		for(int x = 0; x <= num; x++) {
			
		if(simulate() == true) {
			trueCount++;
			count++;
			}
		
		}
				
				
		result =  (double)count/num;
				
		return result;
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 