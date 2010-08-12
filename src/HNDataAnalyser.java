
import java.util.*;
class HNDataAnalyser implements StorageClass{
	Vector words;
	HashMap index;
	int titleIndex;
	int numberOfTitles;
	
	public HNDataAnalyser(){
		words = new Vector();
		index = new HashMap();
		titleIndex = 3;
	}
	
	//Stores the word while analysing it
	public void store( HNDataRecord record){
		String title = getTitle(record);
		Vector uniqueWords = getUniqueWords(title);
		updateStatistic(uniqueWords);
	}
	
	//Gets the title of the post
	public String getTitle( HNDataRecord record){
		return record.get(titleIndex);
	}
	
	//Create a vector of unique words
	private Vector getUniqueWords(String title){
		Vector aVector = new Vector();
		HashMap temp = new HashMap();
		String[] wordsFromLine = title.split(" ");
		for(int i = 0; i <wordsFromLine.length; i++){
			addUniqueWord(wordsFromLine[i],aVector,temp);
		}	
	    return aVector;
	}
	
	//add word to vector list
	private void addUniqueWord(String aWord, Vector aVector, HashMap temp){
			if(!temp.containsKey(aWord)){
				aVector.add(aWord);
				temp.put(aWord,0);
			}
	}
	
	//Update all the words contained in the line
	private void updateStatistic(Vector uniqueWords){
		for(int i = 0; i < uniqueWords.size(); i++){
			String aWord = (String)uniqueWords.get(i);
			storeNewWord(aWord);
			int idx = obtainIndex(aWord);
			incrementIndex(idx);
		}
	}
	
	//Stores a word if it is not stored already a particular spot
	private void storeNewWord(String aWord){
		if(!index.containsKey(aWord)){
			HNWordData newWord = new HNWordData(aWord);
			words.add(newWord);
			index.put(aWord,0);			
		}
	}
	
	//Returns the index of the vector where the statistic about this word is kept
	private int obtainIndex(String aWord){
		Integer ans = (Integer)index.get(aWord);
		return ans.intValue();
	}
	
	//increment the occurence of this word
	private void incrementIndex(int idx){
		HNWordData aWordStat = (HNWordData)words.get(idx);
		aWordStat.incrementOccurrence();
	}
	public Vector getAnalysedData(){
		return words;
	}
}
