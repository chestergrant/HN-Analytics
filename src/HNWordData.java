//Stores meaningful statistics on each word
//In particular the number of titles the word appears
class HNWordData {
	String wordName;
	int freqInTitles;
	int totalKarma;
	
	public HNWordData(String wordName){
		//Initialisation
		this.wordName = wordName;
		freqInTitles = 0;
		totalKarma = 0;
	}
	
	//Increment Number of times seen in a title
	public void incrementOccurrence(){
		freqInTitles++;
	}
	//Increment Karma associated with this word
	public void incrementKarma(int value){
		totalKarma = totalKarma + value;
	}
	
	//Return the total number of Karma accured by this word
	public int karma(){
		return totalKarma;
	}
	//Return the number of times this word has occurred in
	public int freq(){
		return freqInTitles;
	}
	
	//Output this word and it's statistic
	public String toString(){
		String output = wordName+","+freqInTitles+","+totalKarma;
		return output;
	}
}
