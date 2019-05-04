package com.scottlinenberger.utils;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.scottlinenberger.cards.AcesSetting;
import com.scottlinenberger.cards.CardIdentifier;
import com.scottlinenberger.cards.PlayingCard;
import com.scottlinenberger.cards.filter.CardFilter;

public class DeckUtilsTest {

  @Test
  public void DeckUtilsTest_AcesHigh_shouldSetAcesWithOneCorrectHighValue() {
    List<PlayingCard> listCards =
        DeckUtils.generateDeck(
          AcesSetting.HIGH,
          2
        );
    
    /* find the aces and verify they have one, low value */
    listCards
      .stream()
      .filter(CardFilter::aces)
      .forEach(currentCard -> {
        int[] values = currentCard.getValues();
        
        /* verify number of values */
        assertEquals(1, values.length);
        
        /* verify value matches Ace's natural value*/
        int value = values[0];
        assertEquals(CardIdentifier.ACE.getNaturalValue(), value);
      });
  }
  
  @Test
  public void DeckUtilsTest_AcesLow_shouldSetAcesWithOneCorrectLowValue() {
    List<PlayingCard> listCards =
        DeckUtils.generateDeck(
          AcesSetting.LOW,
          2
        );
    
    /* find the aces and verify they have one, low value */
    listCards
      .stream()
      .filter(CardFilter::aces)
      .forEach(currentCard -> {
        int[] values = currentCard.getValues();
        int lowestValue = CardIdentifier.lowestNaturalValue().getNaturalValue();
        
        /* verify number of values */
        assertEquals(1, values.length);
        
        /* verify value matches Ace's low value*/
        int value = values[0];
        assertTrue(value < lowestValue);
      });
  }
  
  @Test
  public void DeckUtilsTest_AcesHighOrLow_shouldSetAcesWithCorrectHighLowValues() {
    List<PlayingCard> listCards =
        DeckUtils.generateDeck(
          AcesSetting.HIGH_AND_LOW,
          2
        );
    
    /* find the aces and verify they have one, low value */
    listCards
      .stream()
      .filter(CardFilter::aces)
      .forEach(currentCard -> {
        int[] values = currentCard.getValues();
        
        int lowestValue = CardIdentifier.lowestNaturalValue().getNaturalValue();
        int aceValue = CardIdentifier.ACE.getNaturalValue();
        
        /* verify number of values */
        assertEquals(2, values.length);
        
        /* verify value matches Ace's high and low values */
        for(int currValue: values) {
          assertTrue(currValue < lowestValue || currValue == aceValue);
        }
        
      });
  }
  
  @Test
  public void DeckUtilsTest_numberOfJokers_shouldBeCorrectlyAddedToDeck() {
    for(int i = 0; i < 10; i++) {
      testNumberOfJokers(i);
    }
  }
  
  private static void testNumberOfJokers(int numberOfJokers) {
    List<PlayingCard> listCards =
        DeckUtils.generateDeck(
          AcesSetting.HIGH_AND_LOW,
          numberOfJokers
        );
    
    int numberOfResults = 
        listCards
          .stream()
          .filter(CardFilter::jokers)
          .collect(Collectors.toList())
          .size();
    
    assertEquals(numberOfJokers, numberOfResults);
  }

}
