package com.scottlinenberger.cards.filter;

import com.scottlinenberger.cards.PlayingCard;

public class CardFilter {

	public static boolean aces(PlayingCard playingCard) {
		return new CardFilterAces() {}.test(playingCard);
	}
	
	public static boolean jokers(PlayingCard playingCard) {
		return new CardFilterJokers() {}.test(playingCard);
	}
}
