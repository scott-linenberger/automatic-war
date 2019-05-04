package com.scottlinenberger.cards.filter;

import java.util.function.Predicate;

import com.scottlinenberger.cards.CardIdentifier;
import com.scottlinenberger.cards.PlayingCard;

public interface CardFilterAces extends Predicate<PlayingCard>{
	@Override
	default public boolean test(PlayingCard playingCard) {
		CardIdentifier cardIdentifier = playingCard.getCardIdentifier();
		
		return CardIdentifier.ACE.equals(cardIdentifier);
	}
	
}
