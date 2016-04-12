package wordFrequency;

import java.io.FileReader;
import java.util.Scanner;

public class ReadFromAFile {
	private String filename="";
	private String rawText="";

	
	ReadFromAFile(){};
	ReadFromAFile(String name){		
		filename = name;
		scannInFile();
	};	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
	}

	private void scannInFile(){
		try{
			
		Scanner sc = new Scanner(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		
	
		while(sc.hasNext()){
			sb.append(sc.next()+ " ");
		}
		rawText = sb.toString();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void populateMap(){
		String[] words = rawText.toString().split(" ");
		for (String string : words) {
			
		}
	}	
	
	@Override
	public String toString() {
		return "filename: " + filename + "\n rawText=" + rawText;
	}
	
	
}

//TODO ask what text file size is assumed
