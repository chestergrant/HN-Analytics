import java.io.*;
import java.util.*;
//Reads the HN Data file and calls the handle after it has the data
class HNDataReader {
	String filename; //Stores the name of the file the HN Data is being hold in
	StorageClass delegate; //Delegate to be called when we are ready to store the data
	public HNDataReader(String filename){
		this.filename = filename;
	}
	
	//Return the record from a line of input text
	private HNDataRecord getRecordData(String inputLine){
		String[] record =  splitLine(inputLine);
		HNDataRecord newRecord = new HNDataRecord();
		for(int i = 0; i < record.length; i++){
			String data = record[i];
			newRecord.add(data);
		}
		return newRecord;		
	}
	
	//Splits the words up into an array
	private String[] splitLine(String inputLine){
		inputLine = inputLine.replace("&quot;","");
		return inputLine.split(",");
	}

	
	//Reads the HN Data file in question
	public void read(){
		try{
		    inputData(filename);			
		}catch(IOException ex){
			inputErrors(ex);
		}
	}
	
	//input lines from from in a data structure name HNDataRecord
	public void inputData(String filename) throws IOException{
	  BufferedReader in = new BufferedReader(new FileReader(filename));
	  String inputLine= "";
	  int count =0;
	  while(((inputLine=in.readLine())!=null)&&(count < 10000)){
	  	        count++;
	  	       	HNDataRecord tempRecord = getRecordData(inputLine);					
				delegate.store(tempRecord);			
		}		
	}
		
	//Error msg
	public void inputErrors(IOException ex){
		System.out.println("Error reading the file");
		System.out.println(ex);
	    System.exit(1);
	}
	
	//Adds handlers to be called when a file has been read
	public void addHandle(StorageClass delegate){
	  this.delegate = delegate;	
	}
}
