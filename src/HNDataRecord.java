import java.util.*;
//Stores one record retrieve from the input file
class HNDataRecord {
	Vector hnDataRecord; //Stores the data read from one line of file
	
	public HNDataRecord(){
		//Initialisation
		hnDataRecord = new Vector();
	} 
	//Adds a data point to the record	
	public void add(String dataPoint){
		hnDataRecord.add(dataPoint);
	}
	//Return the size of the record
	public int size(){
		return hnDataRecord.size();
	}
	//Gets a data point
	public String get(int i){
		return (String)hnDataRecord.get(i);
	}
	
	//Returns the content of the Record
	public String toString(){
		String output = "";
		for(int i = 0; i<size(); i++){
			output += (String)hnDataRecord.get(i);
		}
		return output;
	}
}
