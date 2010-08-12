/**
 * @(#)HNAnalytics.java
 *
 * HNAnalytics application
 *
 * @Chester Grant also creator of www.timeline-x.com 
 * @version 1.00 2010/8/12
 */
 
 import java.io.*;
 import java.util.*;
public class HNAnalytics {
	String filename;
	Vector analysedData;
	
	public HNAnalytics(String filename){
		//initialisation
		this.filename = filename;
		analysedData = new Vector();
	}
    
    public void analyse(){
    	HNDataAnalyser hnDataAnalyser = new HNDataAnalyser();
       	HNDataReader hnDataReader = new HNDataReader(filename);
       	hnDataReader.addHandle(hnDataAnalyser);
       	hnDataReader.read();   	
       	analysedData = hnDataAnalyser.getAnalysedData();    	 	  	
    }
    
    //Sorts the data that has been analysed
    public void sort(){
    	
    	if(analysedData.size() > 1){
    		Collections.sort(analysedData,new HNWordDataComparator());    		
    		return;
    	}
    	System.out.println("Error: No data to sort");
    	System.exit(1);
    	
    }
    //Outputs the content of the analysed data to a file
    public void print(String outputFilename){
    	try{   	
    	    PrintWriter out = new PrintWriter(new FileWriter(outputFilename));
    		for(int i = 0; i < analysedData.size(); i++){
    		   	out.println((HNWordData)analysedData.get(i));
    		   	System.out.println((HNWordData)analysedData.get(i));
    		}
    		out.close();
    	}catch(IOException ex){
    		
    	}
    }
    
    public static void main(String[] args) {
    	
    	String filename = "hntrend.csv";  //Stores the location and filename of the file with the data
    	String outputFilename = "output.txt"; //Stores the location and filename of the file to be output
    	HNAnalytics hnAnalytics = new HNAnalytics(filename); //Initialize
    	hnAnalytics.analyse(); //Gets the statistic out of the data
    	hnAnalytics.sort(); //Stores the data in a meaningful manner
    	hnAnalytics.print(outputFilename); // Outputs the data to file specified
    	
    }
}
