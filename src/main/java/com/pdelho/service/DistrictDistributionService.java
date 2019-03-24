package com.pdelho.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.pdelho.model.PartyVotes;

public class DistrictDistributionService {
	
	public static Map<String, Integer> getSeatsByProvince (final List<PartyVotes> partyVotes, final Integer seats)
	{
		//TODO 3% valid	
		
		
		final TreeSet<PartyVotes> votesOrdered = new TreeSet<PartyVotes>();
		for (PartyVotes vote : partyVotes) 
		{
		    String party = vote.getPartyId();
		    Integer votesForParty = vote.getNumberOfVotes();
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
		System.out.println(result);
		return result;
	}
	

}
