package com.evllabs.grader;

import java.util.*;

import com.evllabs.grader.structures.Histogram;

public class Grader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int counter = 0;
		Histogram authors = new Histogram();
		Map<String, List<Histogram>> ranks = new HashMap<String, List<Histogram>>();
		List<Histogram> currentRanks = new ArrayList<Histogram>();
		while(input.hasNext()){
			String line = input.nextLine();
			if(counter == 0){
				authors.add(line);
				currentRanks = ranks.get(line);
				if(currentRanks == null){
					currentRanks = new ArrayList<Histogram>();
					ranks.put(line, currentRanks);
				}
			}else if(counter > 5){
				if(line.isEmpty()){
					continue;
				}else if(line.equalsIgnoreCase("------------------------")){
					counter = 0;
					continue;
				}
				int rank = counter -5;
				Histogram currentRank;
				try{
					currentRank = currentRanks.get(rank);
				} catch(IndexOutOfBoundsException e){
					currentRank = new Histogram();
					currentRanks.add(currentRank);
				}
				currentRank.add(line);
			}
			counter++;
		}
		

	}

}
