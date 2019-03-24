package com.pdelho.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import com.pdelho.model.PartyVotes;

public class DistrictDistributionService {
	
	public static Map<String, Integer> getSeatsByProvince (final HashMap<String, Integer> votes, final Integer seats)
	{
		//TODO 3% valid	
		
		
		final TreeSet<PartyVotes> votesOrdered = new TreeSet<PartyVotes>();
		for (Entry<String, Integer> vote : votes.entrySet()) 
		{
		    String party = vote.getKey();
		    Integer votesForParty = vote.getValue();
		    // Divide each vote into N seats
		    for (int i=1; i<= seats; i++)
		    {
		    	votesOrdered.add(new PartyVotes(party, votesForParty/i));	    	
		    }
		}
		
		// Limit to N seats results
		final List<PartyVotes> votesOrderedList =new ArrayList<PartyVotes>(votesOrdered).subList(0, seats);
		// Get the parties
		final List<String> seatsByParty = new ArrayList<String>(votesOrderedList.size());
		for (PartyVotes voteOrdered : votesOrderedList)
		{
			seatsByParty.add(voteOrdered.getPartyId());
		}
		
		// Count duplicates
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String party : seatsByParty) 
		{
			if (result.containsKey(party)) 
			{
				result.put(party, result.get(party) + 1);
			} 
			else 
			{
				result.put(party, 1);
			}
		}
		
		return result;
	}
	
	public static void main (String[] args)
	{
		final HashMap<String, Integer> test = new HashMap<String, Integer>();
		test.put("PP", 800000);
		test.put("UP", 450000);
		test.put("PSOE", 900000);
		test.put("CS", 400000);
		test.put("VOX", 600000);
		
		Map<String, Integer> result = getSeatsByProvince(test,36);
		System.out.println(result);
		
		
		
	}
	

}
