package com.pdelho.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pdelho.model.PartyVotes;

public class DistrictDistributionService {

	public static Map<String, Integer> getSeatsByProvince (final List<PartyVotes> partyVotes, final Integer seats)
	{
		//TODO 3% valid	
		final Set<PartyVotes> votesOrdered = new TreeSet<PartyVotes>();
		partyVotes.stream().forEach((vote)->
		{
			// Divide each vote into N seats and add it. Tree set: the party is added before if their votes are higher
			for (int i=1; i<= seats; i++)
			{
				votesOrdered.add(new PartyVotes(vote.getPartyId(),  vote.getNumberOfVotes()/i));	    	
			}
		});
		// Limit to the first greater N seats results (first stream gets a Set) and then get the id of the parties (second stream gets a List)
		final List<String> partiesSeats = votesOrdered.stream().limit(seats).collect(Collectors.toSet())
				.stream().map(vote->vote.getPartyId()).collect(Collectors.toList());
		// Count frequency of each party
		Map<String, Integer> result = partiesSeats.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
		return result;
	}

	public static void main (String[] args)
	{
		List<PartyVotes> partyVotes = new ArrayList<PartyVotes>();
		partyVotes.add(new PartyVotes("PP", 5000));
		partyVotes.add(new PartyVotes("PSOE", 6000));
		partyVotes.add(new PartyVotes("CS", 3000));
		partyVotes.add(new PartyVotes("VOX", 2000));
		partyVotes.add(new PartyVotes("UP", 2000));
		System.out.println(getSeatsByProvince(partyVotes, 10));
	}


}
