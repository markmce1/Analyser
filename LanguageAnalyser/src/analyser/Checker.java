package analyser;

import java.util.ArrayList;

public class Checker
{
	private int slangcounter = 0;
	private int formalcounter = 0;
	 ArrayList<Integer> slangorformal = new ArrayList<Integer>();
	 
	public ArrayList<Integer> slangcheck(ArrayList<Integer> num_vars) {
		
		if(num_vars.get(0)> num_vars.get(1))//if slang is over the the amount of formal words picked up
		{
			slangcounter++;
		}
		else
		{
			formalcounter++;
		}
		if(num_vars.get(2) > 7)//for average words per sentence being over 7
		{
			formalcounter++;
		}
		else 
		{
			slangcounter++;
		}
		if(num_vars.get(3) == num_vars.get(2))
		{
				formalcounter++;
		}
		else 
		{
				slangcounter++;
		}
		slangorformal.add(slangcounter);
		slangorformal.add(formalcounter);
		
		return slangorformal;
	}
	 

}

