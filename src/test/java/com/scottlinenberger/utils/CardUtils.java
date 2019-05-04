package com.scottlinenberger.utils;

import java.util.Arrays;

import com.scottlinenberger.cards.PlayingCard;

public class CardUtils {

  public static int compareCards(PlayingCard card1, PlayingCard card2) {

    int[] valuesCard1 = card1.getValues();
    int[] valuesCard2 = card2.getValues();

    /* sort the values for each array */
    Arrays.sort(valuesCard1);
    Arrays.sort(valuesCard2);

    /* get the largest, last value of the sorted array */
    int valueCard1 = valuesCard1[valuesCard1.length - 1];
    int valueCard2 = valuesCard2[valuesCard2.length - 1];

    int comparison = valueCard1 - valueCard2;
    
    if (comparison == 0) {
      return 0;
    }
    
    if (comparison > 0) {
      return 1;
    }
    
    if (comparison < 0) {
      return -1;
    }
    
    return 0;
  }

}
