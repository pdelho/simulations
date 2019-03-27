package com.pdelho.model;

import java.util.List;

public class PartyVotesForm {

	private List<PartyVotes> partyVotes;
	
	public PartyVotesForm(List<PartyVotes> partyVotes) {
		super();
		this.partyVotes = partyVotes;
	}

	public PartyVotesForm() {
		super();
	}

	public List<PartyVotes> getPartyVotes() {
		return partyVotes;
	}

	public void setPartyVotes(List<PartyVotes> partyVotes) {
		this.partyVotes = partyVotes;
	}
	
}
