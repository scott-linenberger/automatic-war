package com.scottlinenberger.cards;

public enum CardSuit {
	HEARTS("Hearts"),
	DIAMONDS("Diamonds"),
	CLUBS("Clubs"),
	SPADES("Spades");
	
	private String stringValue;
	
	CardSuit(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public String toString() {
		return this.stringValue;
	}
}
