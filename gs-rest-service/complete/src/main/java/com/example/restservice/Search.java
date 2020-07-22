package com.example.restservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {
	
	private final long id;
	private final String term;
	private String content = "";
	private String results = "";
	private static final String template = "Your search term '%s' returned %s";
	
	public Search(long id, String term){
		this.id = id;
		this.term = term;
	}
	
	public void find(){
		int lineCounter = 0;
		int foundCount = 0;
		try(BufferedReader br = new BufferedReader( new FileReader
				("C:\\Users\\XFGFD9867\\Spring Files to Read\\comedy of errors.txt"))){
			String line;
			while((line = br.readLine()) != null){
				lineCounter++;
				Scanner word = new Scanner(line);
				while(word.hasNext()){
					String thisWord = word.next();
					if(thisWord.matches("(.*)"+term+".*")){
						foundCount++;
						results += "line " + lineCounter +" (" + thisWord + ") ";
					}
				}
				word.close();
			}
			if (results == "")
				results = "none";
			results = foundCount + " results: " + results;

		}catch (IOException e){
			System.out.println("IOException occured");
			e.printStackTrace();
		}
	}
	
	public long getId() {
		return id;
	}

	public String getContent() {
		content = String.format(template, term, results);
		return content;
	}
}
