package analyser;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


	public class screen extends JFrame implements ActionListener
	{
		
		  /* attributes:
	    note: it's good to set up the GUI components as class attributes , 
	    instead of in the constructor so that they are visible/ usable in all method
	   */	
	     
	   private JButton 		button2;
	   private JTextField 	tf1;
	   private JTextArea	textbox1;
	   ArrayList<String> fileName = new ArrayList<String>();
	   String slangWord;
	   String newline = "\n";
	   
	// constructor
	   screen(String title)
	   {

		   super(title);
		   setSize(650,150);
		   setLayout(new FlowLayout());
		   
		   // create / instantiate the GUI components and add listener
		   button2  = new JButton("Add to file");
		   tf1 		= new JTextField("Enter slang words");
		   textbox1 = new JTextArea(5,20);
		   JScrollPane scrollPane = new JScrollPane(textbox1); 
	  
		   tf1.setToolTipText("Enter slang words");
		   tf1.addActionListener(this);
		   
		   button2.setToolTipText("Click me");
		   button2.addActionListener(this);
		   
		   add(tf1);
		   add(button2);
		   add(textbox1);
		   
		   setVisible(true);
			
		   textbox1.append("Choose a txt file to read in\n");
//start of reference from https://www.mkyong.com/swing/java-swing-jfilechooser-example/		
		   
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			jfc.setFileFilter(filter);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				fileName.add(jfc.getSelectedFile().toString());

				textbox1.append("Now choose a Slang word txt file\n");
								
				JFileChooser FC2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FC2.setFileFilter(filter);
				int returnValue2 = FC2.showOpenDialog(null);
				if (returnValue2 == JFileChooser.APPROVE_OPTION) {
					File selectedFile2 = FC2.getSelectedFile();
					fileName.add(FC2.getSelectedFile().toString());
//end of reference
				FileOpener callClass = new FileOpener();
				ArrayList<Integer> num_vars = callClass.openFile(fileName);

				Checker callClassChck = new Checker();
				ArrayList<Integer> slangorformal = callClassChck.slangcheck(num_vars);
				if(slangorformal.get(0) > slangorformal.get(1))
				{
					textbox1.append("This is a slang document, the results are " + slangorformal.get(0) + " for slang and " + slangorformal.get(1) + " for formal.") ;
	    		}else
	    		{
		    		textbox1.append("This is a formal document, the results are " + slangorformal.get(0) + " for slang and " + slangorformal.get(1) + " for formal.") ;
	    		}
				}//end of second File chooser
			}//end of File chooser
	   }//end of class
		@Override
	   public void actionPerformed(ActionEvent event)
	   {
	   	
	      if(event.getSource()== button2) 
	      {
	    		String slangWord = tf1.getText();
	    		System.out.println(slangWord + newline);
	    		try {
	    			//To append the slang word to the end of the text file and to make a space
	    			Files.write(Paths.get(fileName.get(1)), newline.getBytes(), StandardOpenOption.APPEND);
	    			Files.write(Paths.get(fileName.get(1)), slangWord.getBytes(), StandardOpenOption.APPEND);
	    		}catch (IOException e) {
	    			//Error
	    			System.out.println("File not found");
	    		}//end of try/catch
				}//end of if statement
	    		}//end of button2 press action
	}//end of class
	      
	   


