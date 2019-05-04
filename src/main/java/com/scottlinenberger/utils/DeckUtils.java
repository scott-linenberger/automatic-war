package com.scottlinenberger.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

import com.scottlinenberger.cards.AcesSetting;
import com.scottlinenberger.cards.CardIdentifier;
import com.scottlinenberger.cards.CardSuit;
import com.scottlinenberger.cards.PlayingCard;
import com.scottlinenberger.cards.filter.CardFilter;
import com.scottlinenberger.cards.generators.CardGenerator;
import com.scottlinenberger.game.player.Player;

public class DeckUtils {
  public static List<PlayingCard> generateDeck(
      AcesSetting acesSetting,
      int numberOfJokers
  ) {
    /* add non-sequential or non-standard cards */
    List<PlayingCard> listCards = generateStandardSequentialCards();

    /* apply the settings for aces */
    applyAcesSetting(listCards, acesSetting);

    /* add jokers */
    addJokers(numberOfJokers, listCards);

    /* shuffle */
    listCards = shuffleCards(listCards);

    return listCards;
  }

  /**
   * Generates a list of the standard, sequential playing cards. That is:
   * playing cards that have a suit and a natural value.
   * 
   * Skips non-sequential cards like Jokers.
   * 
   * @return
   */
  private static List<PlayingCard> generateStandardSequentialCards() {
    List<PlayingCard> listCards = new ArrayList<>();

    /* Generate sequential cards */

    /* loop through the suits */
    for (CardSuit cardSuit : CardSuit.values()) {
      /* loop through the card values */
      for (CardIdentifier cardValue : CardIdentifier.values()) {

        /* skip jokers */
        if (cardValue.equals(CardIdentifier.JOKER)) {
          continue;
        }

        /* build a new playing card */
        PlayingCard playingCard = CardGenerator
            .generateSingleValueStandardCard(cardValue, cardSuit);

        /* add the card to the list */
        listCards.add(playingCard);
      }
    }

    return listCards;
  }

  private static List<PlayingCard> applyAcesSetting(
      List<PlayingCard> listCards,
      AcesSetting acesSetting
  ) {

    int lowValue = CardIdentifier.lowestNaturalValue().getNaturalValue() - 1;

    switch (acesSetting) {
      case HIGH_AND_LOW:
        /* aces are high and low, add the lowest value minus 1 */
        listCards.stream().filter(CardFilter::aces).forEach(currentAce -> {
          int naturalValue = CardIdentifier.ACE.getNaturalValue();
          int[] values = new int[] { lowValue, naturalValue };

          /* update the Ace's values */
          currentAce.setValues(values);
        });

        break;

      case LOW:
        /* aces are low, set the lowest value minus 1 */
        listCards.stream().filter(CardFilter::aces).forEach(currentAce -> {
          int[] values = new int[] { lowValue };

          /* update the Ace's values */
          currentAce.setValues(values);
        });
        break;

      case HIGH:
      default: /* defaults to aces high */
        /* aces are naturally high, no need to augment */
        break;
    }

    return null;
  }

  public static void printDeck(List<PlayingCard> listCards) {
    listCards.forEach(currentItem -> {
      String identifier = currentItem.toString();
      int[] values = currentItem.getValues();

      StringJoiner joiner = new StringJoiner(",");

      for (int value : values) {
        joiner.add(String.valueOf(value));
      }

      System.out.println(identifier + ": Values[" + joiner.toString() + "]");
    });
  }

  public static List<PlayingCard> shuffleCards(List<PlayingCard> listCards) {
    /* convert the list to an array */
    Object[] arrayCards = listCards.toArray();

    arrayCards = ArrayScrambler.shuffleArray(arrayCards);

    List<PlayingCard> shuffledList = new ArrayList<>();

    for (int i = 0; i < arrayCards.length; i++) {
      PlayingCard currentCard = (PlayingCard) arrayCards[i];
      shuffledList.add(currentCard);
    }

    return shuffledList;
  }
  
  public static void dealCards(
      Player player1,
      Player player2,
      List<PlayingCard> listCards) {
    
    Stack<PlayingCard> stackCardsP1 = new Stack<PlayingCard>();
    Stack<PlayingCard> stackCardsP2 = new Stack<PlayingCard>();
    
    int index = 0;
    
    for(PlayingCard currentCard: listCards) {
      if (index % 2 == 0) {
        stackCardsP1.push(currentCard);
      } else {
        stackCardsP2.push(currentCard);
      }
      
      index++;
    }
    
    player1.setStackCards(stackCardsP1);
    player2.setStackCards(stackCardsP2);
  }
  
  private static void addJokers(
      int numberOfJokers,
      List<PlayingCard> listCards
  ) {
    for (int i = 0; i < numberOfJokers; i++) {
      PlayingCard joker = CardGenerator.generateJoker();
      listCards.add(joker);
    }
  }
}
