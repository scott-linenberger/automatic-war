package com.scottlinenberger.cards;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum CardIdentifier {
	TWO(2, "Two"),
	THREE(3, "Three"), 
	FOUR(4, "Four"), 
	FIVE(5, "Five"), 
	SIX(6, "Six"), 
	SEVEN(7, "Seven"), 
	EIGHT(8, "Eight"),
	NINE(9, "Nine"),
	TEN(10, "Ten"), 
	JACK(11, "Jack"), 
	QUEEN(12, "Queen"), 
	KING(13, "King"),
	ACE(14, "Ace"), /* native ace value is HIGH */
	JOKER(15, "Joker"); /* native joker is HIGHEST value */

	private int naturalValue;
	private String stringValue;

	CardIdentifier(
			int naturalValue,
			String stringValue) {
		
		this.naturalValue = naturalValue;
		this.stringValue = stringValue;
	}

	public int getNaturalValue() {
		return this.naturalValue;
	}

	private static List<CardIdentifier> valuesAsList() {
		return Arrays.asList(CardIdentifier.values());
	}

	public static CardIdentifier lowestNaturalValue() {
		return valuesAsList()
				.stream()
				.min(
					Comparator.comparing(
						CardIdentifier::getNaturalValue
					)
				)
				.get();
	}

	public static CardIdentifier highestNaturalValue() {
		return valuesAsList()
				.stream()
				.max(
					Comparator.comparing(
						CardIdentifier::getNaturalValue
					)
				)
				.get();
	}
	
	@Override
	public String toString() {
		return this.stringValue;
	}
}
