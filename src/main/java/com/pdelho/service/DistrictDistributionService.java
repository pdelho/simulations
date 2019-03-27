package com.pdelho.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pdelho.model.PartyVotes;

public class DistrictDistributionService {

	public static Map<String, Integer> getRepresentatives (final List<PartyVotes> partyVotes)
	{
		// Group votes by province
		Map<String, List<PartyVotes>> votesByProvince = partyVotes.stream()
				.collect(Collectors.groupingBy(vote -> vote.getProvince(), Collectors.mapping((PartyVotes p) -> p, Collectors.toList())));
		
		// Assing the seats to the parties
		List<String> seatsForParties = new ArrayList<String>(350);
		votesByProvince.forEach((provinice, vote)->
		{
			seatsForParties.addAll(getPartiesSeatsForProvince(vote, vote.get(0).getSeatsForProvince()));
			System.out.println(vote.toString());
		});
		
		// List<String> partiesSeats = getPartiesSeatsForProvince(partyVotes, partyVotes.get(0).getSeatsForProvince());
	
		// Count frequency of each party
		Map<String, Integer> result = seatsForParties.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
		return result;
	}
	
	protected static List<String> getPartiesSeatsForProvince (final List<PartyVotes> partyVotes, final Integer seats)
	{
		final Set<PartyVotes> votesOrdered = new TreeSet<PartyVotes>();
		partyVotes.stream().forEach((vote)->
		{
			// Divide each vote into N seats and add it. Tree set: the party is added before if their votes are higher
			for (int i=1; i<= vote.getSeatsForProvince(); i++)
			{
				votesOrdered.add(new PartyVotes(vote.getProvince(), vote.getSeatsForProvince(), vote.getPartyId(),  vote.getNumberOfVotes()/i));	    	
			}
		});
		// Limit to the first greater N seats results (first stream gets a Set) and then get the id of the parties (second stream gets a List)
		return votesOrdered.stream().limit(seats).collect(Collectors.toSet())
				.stream().map(vote->vote.getPartyId()).collect(Collectors.toList());
	}

	public static void main (String[] args)
	{
		List<PartyVotes> partyVotes = new ArrayList<PartyVotes>();
		partyVotes.add(new PartyVotes("Madrid", 36, "PP", 16));
		partyVotes.add(new PartyVotes("Madrid", 36, "PSOE", 8));
		partyVotes.add(new PartyVotes("Madrid", 36, "CS", 4));
		partyVotes.add(new PartyVotes("Madrid",36, "VOX", 2));
		partyVotes.add(new PartyVotes("Madrid",36, "UP", 1));
		partyVotes.add(new PartyVotes("Barcelona",30, "PP", 100));
		partyVotes.add(new PartyVotes("Barcelona",30, "UP", 100));
		System.out.println(getRepresentatives(partyVotes));
	}


}
