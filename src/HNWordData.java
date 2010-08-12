//Stores meaningful statistics on each word
//In particular the number of titles the word appears
class HNWordData {
	String wordName;
	int freqInTitles;
	
	public HNWordData(String wordName){
		//Initialisation
		this.wordName = wordName;
		freqInTitles = 0;
	}
	
	//Increment Number of times seen in a title
	public void incrementOccurrence(){
		freqInTitles++;
	}
	public void incrementOccurrence(int value){
		freqInTitles =+ value;
	}
	
	//Return the number of times this word has occurred in
	public int freq(){
		return freqInTitles;
	}
	
	//Output this word and it's statistic
	public String toString(){
		String output = wordName+","+freqInTitles;
		return output;
	}
}
