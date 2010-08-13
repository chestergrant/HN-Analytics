import java.util.Comparator;
//Used to compare to words by the thier frequencies in title
class HNWordDataComparator implements Comparator<HNWordData> {
	
	public int compare(HNWordData word1, HNWordData word2){
	  
	  if(word1.averageKarma()>word2.averageKarma()){
	  	return -1;
	  }
	  if(word1.averageKarma()==word2.averageKarma()){
	  	return 0;
	  }			
	  return 1;
	}
}
