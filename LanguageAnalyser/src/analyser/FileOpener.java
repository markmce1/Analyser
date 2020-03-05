package analyser;

import java.io.*;
import java.util.*;

public class FileOpener
{

	private Scanner filePath;
	 private Scanner slangPath;
	 
	 ArrayList<String> textFile = new ArrayList<String>();
	 ArrayList<String> slangFile = new ArrayList<String>();
	 ArrayList<Integer> num_vars = new ArrayList<Integer>();
	 ArrayList<Character> Caps = new ArrayList<Character>();


	public ArrayList<Integer> openFile(ArrayList<String> fileName) {
		Caps.add('A');Caps.add('B');Caps.add('C');Caps.add('D');Caps.add('E');Caps.add('F');Caps.add('G');Caps.add('H');
		Caps.add('I');Caps.add('J');Caps.add('K');Caps.add('L');Caps.add('M');Caps.add('N');Caps.add('O');Caps.add('P');
		Caps.add('Q');Caps.add('R');Caps.add('S');Caps.add('T');Caps.add('U');Caps.add('V');Caps.add('W');Caps.add('X');
		Caps.add('Y');Caps.add('Z');
		int LoopCounter = 0;
		int LoopSlangCounter = 0;
		int slangCounter = 0;
		int charlength = 0;
		int FormalCounter = 0;
		int avglength = 0;
		int fullstopcount = 0;
		int avgwordpersent = 0;
		int capcount = 0;
		String line1 = "";
		String[] split1;
		String fileNameSlang = fileName.get(1);
		String fileNametxt = fileName.get(0);
	try {
		slangPath = new Scanner(new File(fileNameSlang));
		filePath =new Scanner(new File(fileNametxt));
		System.out.println("File opened");
		
		while(filePath.hasNext()) {
			String a = filePath.next();

			for(int h = 0;h != a.length() ; h ++)
			{
				char fullStop = '.';
				char[] chars =  a.toCharArray();
				int size = Caps.size();
				if(a.charAt(h) == fullStop)//counts full stops
				{
					fullstopcount++;
				}//counts full stops, end of if
				for(int j = 0; j <size; j++)
				{
					char capslet = Caps.get(j);
					char letter = a.charAt(h);
				if(letter==capslet)
				{
					capcount++;
					System.out.println(capcount);
					System.out.println("code works " + letter);
				}
				}
			}
			a = a.toLowerCase();
			charlength = a.length();
			avglength = avglength + charlength;
			if(a.length() > 7) {
				FormalCounter ++;
			}

			textFile.add(a);
			LoopCounter ++;
}//end of while loop
		while(slangPath.hasNext()) {
			String d = slangPath.next();
			d = d.toLowerCase();
			
			slangFile.add(d);
			LoopSlangCounter ++;

}//end of while loop
		for (int i = 0; i < LoopCounter; i++) 
		{
			if(slangFile.contains(textFile.get(i))) {
				slangCounter ++;
			}//end of if statement
		}// end of for loop
		avgwordpersent = LoopCounter / fullstopcount;//makes it so its the average words per sentence in the file
		avglength = avglength / LoopCounter;
		num_vars.add(slangCounter);//0
		num_vars.add(FormalCounter);//1
		num_vars.add(avgwordpersent);//2
		num_vars.add(capcount);//3
		num_vars.add(avglength);//4
		num_vars.add(fullstopcount);//5
	} catch (Exception e) {
		System.out.println("Big ol error boi");
	}//end of try/catch
	return num_vars;
}//end of class
}
