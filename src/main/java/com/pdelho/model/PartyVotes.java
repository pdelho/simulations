package com.pdelho.model;

public class PartyVotes implements Comparable<PartyVotes> {

	private String partyId;
	
	private Integer numberOfVotes;
	
	public PartyVotes(String partyId, Integer numberOfVotes) {
		super();
		this.partyId = partyId;
		this.numberOfVotes = numberOfVotes;
	}

	public PartyVotes() {
		super();
	}

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
	 public int compare(PartyVotes partyVotes1, PartyVotes partyVotes2) {
         return partyVotes1.getNumberOfVotes().compareTo(partyVotes2.getNumberOfVotes());
     }

	@Override
	public int compareTo(PartyVotes partyVotes) {
		int result = partyVotes.getNumberOfVotes()>= numberOfVotes ? 1 : -1;
		return result;
	}

	
	
}
