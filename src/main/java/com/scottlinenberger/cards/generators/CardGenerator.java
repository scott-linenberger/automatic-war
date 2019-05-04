package com.scottlinenberger.cards.generators;

import com.scottlinenberger.cards.CardSuit;
import com.scottlinenberger.cards.CardIdentifier;
import com.scottlinenberger.cards.PlayingCard;

public abstract class CardGenerator {

	public static PlayingCard generateSingleValueStandardCard(
			CardIdentifier cardIdentifier, 
			CardSuit cardSuit) {
		
		/* build the suit and value strings */
		String stringValue = cardIdentifier.toString() + " of " + cardSuit.toString();
		
		/* build the natural values */
		int[] values = new int[] { cardIdentifier.getNaturalValue() };
		
		return new PlayingCard(
				cardIdentifier,
				cardSuit,
				values,
				stringValue);
	}
	
	public static PlayingCard generateJoker() {
		CardIdentifier identifier = CardIdentifier.JOKER;
		int value = identifier.getNaturalValue();
		
		return new PlayingCard(
				identifier,
				null,
				new int[] { value },
				"Joker");
	}
	
}
