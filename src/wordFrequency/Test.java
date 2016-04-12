package wordFrequency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		// testKsWordCount("hello world Yes I am upset. Someone from the IC2");
		testKsSplit("9 different optimization techniques are tried.");
		System.out.println();
		testKsSplit("91different1optimization1techniques1are1tried.", '1');
	}

	public static ReadFromAFile constructReadFromAFile() {
		ReadFromAFile rfa = new ReadFromAFile("text.txt");
		return rfa;
	}

	public ReadFromAFile constructReadFromAFile(String filename) {
		ReadFromAFile rfa = new ReadFromAFile(filename);
		return rfa;
	}

	public static void testReadFromAFile_Constructor() {
		 ReadFromAFile rfa = constructReadFromAFile();
		 System.out.println(rfa.toString());
	}

	public static void countWordFrequency(String str) {

		Map<String, Integer> map = new TreeMap<String, Integer>();
		String[] wRaw = str.split(" ");
		Integer count = 0;
		for (String w : wRaw) {
			count = (Integer) map.get(w);
			count = (!count.equals(null)) ? 1 : count++;
			map.put(w, count);
		}
	}

	public static void countWordFrequencyWitoutJavaUtil(String str) {
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

	public static String[] ksSplit(String strIn) {

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
	public static String[] ksSplit(String strIn, char delim) {

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

	public static int ksWordCount(String strIn) {
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
	public static int ksWordCount(String strIn, char delim) {
		int count = 1;
		strIn = strIn.trim();
		for (int i = 0; i < strIn.length(); i++) {
			if (strIn.charAt(i) == delim) {
				count++;
			}
		}
		return count;
	}


	public static void testKsWordCount(String str) {
		System.out.println(ksWordCount(str));
	}

	public static void testKsSplit(String str) {
		String[] words = ksSplit(str);
		for (String w : words) {
			System.out.print(w + " ");
		}
	}

	// OVERLOAD
	public static void testKsSplit(String str, char delim) {
		String[] words = ksSplit(str, delim);
		for (String w : words) {
			System.out.print(w + " ");
		}
	}
}
