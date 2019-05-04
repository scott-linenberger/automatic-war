package com.scottlinenberger.cards;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CardValueTest {
	
	@Test public void getLowestValue_shouldReturnTheLowestValue() {
		int lowestValue = CardIdentifier
				.lowestNaturalValue()
				.getNaturalValue();
		
		for(CardIdentifier cardValue: CardIdentifier.values()) {
			int currentValue = cardValue.getNaturalValue();
			
			if (currentValue < lowestValue) {
				fail();
			}
		}
		
		/* no lower values were found! */
		assertTrue(true);
	}
	
	@Test public void getHighestValue_shouldReturnTheHighestValue() {
		int highestValue = CardIdentifier
				.highestNaturalValue()
				.getNaturalValue();
		
		for(CardIdentifier cardValue: CardIdentifier.values()) {
			int currentValue = cardValue.getNaturalValue();
			
			if (currentValue > highestValue) {
				fail();
			}
		}
		
		/* no higher values were found! */
		assertTrue(true);
	}

}
