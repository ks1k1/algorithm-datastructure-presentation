package wordFrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordStat {
	private ReadFromAFile source = null;
	private int wc =0;
	private Map wordFrequency = new TreeMap<Integer, String>();
	
	public WordStat(){}
	public WordStat(String filename){
		source = new ReadFromAFile(filename);
		//wc = ksWordCount(source.)
	}
	
	public Map<String, Integer> sortMapByValue(Map<String, Integer> mapIn){
		
		Comparator<String> comparator = new ValueComparator(mapIn);
		Map<String, Integer> sorted = new TreeMap(comparator);
		
		return sorted;
	}
	
	public void countWordFrequency(String str) {

		Map<String, Integer> map = new TreeMap<String, Integer>();
		String[] wRaw = str.split(" ");
		Integer count = 0;
		for (String w : wRaw) {
			count = (Integer) map.get(w);
			count = (!count.equals(null)) ? 1 : count++;
			map.put(w, count);
		}
	}

	public void countWordFrequencyWitoutJavaUtil(String str) {
		String[] wRaw = str.split(" ");
		List words = new ArrayList<String>();
		int[] counts = new int[words.size()];

		for (String w : wRaw) {
			if (words.contains(w)) {
				counts[words.indexOf(w)]++;
			} else {

			}

		}
	}

	public String[] ksSplit(String strIn) {

		String[] words = new String[ksWordCount(strIn)];
		int beginIdx = 0;
		int wordsIdx = 0;
		int currIdx = 0;

		for (currIdx = 0; currIdx < strIn.length(); currIdx++) {
			if (strIn.charAt(currIdx) == ' ') {
				words[wordsIdx] = strIn.substring(beginIdx, currIdx);
				wordsIdx++;
				beginIdx = currIdx + 1;
			}
		}
		// add the last word to words array
		words[wordsIdx] = strIn.substring(beginIdx, currIdx);

		return words;
	}

	// OVERLOAD 1: specifies delimiter
	public String[] ksSplit(String strIn, char delim) {

		String[] words = new String[ksWordCount(strIn, delim)];
		int beginIdx = 0;
		int wordsIdx = 0;
		int currIdx = 0;

		for (currIdx = 0; currIdx < strIn.length(); currIdx++) {
			if (strIn.charAt(currIdx) == delim) {
				words[wordsIdx] = strIn.substring(beginIdx, currIdx);
				wordsIdx++;
				beginIdx = currIdx + 1;
			}
		}
		// add the last word to words array
		words[wordsIdx] = strIn.substring(beginIdx, currIdx);

		return words;
	}

	public int ksWordCount(String strIn) {
		int count = 1;
		strIn = strIn.trim();
		for (int i = 0; i < strIn.length(); i++) {
			if (strIn.charAt(i) == ' ') {
				count++;
			}
		}
		return count;
	}

	// OVERLOAD 1
	public int ksWordCount(String strIn, char delim) {
		int count = 1;
		strIn = strIn.trim();
		for (int i = 0; i < strIn.length(); i++) {
			if (strIn.charAt(i) == delim) {
				count++;
			}
		}
		return count;
	}


}
