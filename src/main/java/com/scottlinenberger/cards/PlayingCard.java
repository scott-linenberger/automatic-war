package com.scottlinenberger.cards;

public class PlayingCard {
	private int[] values;
	private CardIdentifier cardIdentifier;
	private CardSuit cardSuit;
	private String stringValue;
	
	public PlayingCard(
			CardIdentifier cardIdentifier,
			CardSuit cardSuit,
			int[] values,
			String stringValue) {
		
		this.values = values;
		this.cardIdentifier = cardIdentifier;
		this.cardSuit = cardSuit;
		this.stringValue = stringValue;
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public CardIdentifier getIdentifier() {
		return cardIdentifier;
	}

	public void setIdentifier(CardIdentifier identifier) {
		this.cardIdentifier = identifier;
	}
	
	
	public CardIdentifier getCardIdentifier() {
		return cardIdentifier;
	}

	public void setCardIdentifier(CardIdentifier cardIdentifier) {
		this.cardIdentifier = cardIdentifier;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}

	@Override
	public String toString() {
		return this.stringValue;
	}
}
