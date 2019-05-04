package com.scottlinenberger.cards.filter;

import java.util.function.Predicate;

import com.scottlinenberger.cards.CardIdentifier;
import com.scottlinenberger.cards.PlayingCard;

public interface CardFilterJokers extends Predicate<PlayingCard>{
	@Override
	public default boolean test(PlayingCard playingCard) {
		CardIdentifier identifier = playingCard.getCardIdentifier();
		
		return CardIdentifier.JOKER.equals(identifier);
	}
}
