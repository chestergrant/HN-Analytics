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
		int totalKarmaBefore = totalKarma;
		totalKarma = totalKarma + value;
		/*if(totalKarma/2 == totalKarmaBefore){
			System.out.println(value);
			System.exit(1);
		}*/
	}
	public int rank(){
		if(freq() >3 ){
			return averageKarma();
		}
		return 0 ;
	}
	
	//Returns the average Karma of a word
	public int averageKarma(){
		return totalKarma /freqInTitles;
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
		String output = wordName+","+freqInTitles+","+totalKarma+","+averageKarma();
		return output;
	}
}
