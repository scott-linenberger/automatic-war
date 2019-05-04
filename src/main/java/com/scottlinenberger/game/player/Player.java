package com.scottlinenberger.game.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.scottlinenberger.cards.PlayingCard;
import com.scottlinenberger.utils.DeckUtils;

public class Player {

  private Stack<PlayingCard> stackCards;
  private List<PlayingCard> listCardsWon;
  private String name;
  
  
  public Player(String name) {
    this.name = name;
    listCardsWon = new ArrayList<>();
  }

  public Stack<PlayingCard> getStackCards() {
    return stackCards;
  }

  public void setStackCards(Stack<PlayingCard> stackCards) {
    this.stackCards = stackCards;
  }

  public PlayingCard getNextCard() {
    /* if card stack is empty */
    if (stackCards.isEmpty()) {
       /* add won cards to card stack */
      addWonCardsToStack();
    }
    
    return this.stackCards.pop();
  }
  
  private void addWonCardsToStack() {
    /* shuffle won cards */
    List<PlayingCard> shuffledCards = DeckUtils.shuffleCards(listCardsWon);
      
    /* add won cards to the card stack */
    for (PlayingCard currentCard: shuffledCards) {
      stackCards.push(currentCard);
    }
  }
  
  public void claimCards(Stack<PlayingCard> stackClaimedCards) {
    /* add the claimed cards to the bottom of the stack */
    Iterator<PlayingCard> iterator = stackClaimedCards.iterator();
    
    System.out.println("\n" + name + " won the following cards: ");
    System.out.println("------------------------------------");
    
    while (iterator.hasNext()) {
      PlayingCard currentCard = iterator.next();
      System.out.println("* " + currentCard.toString());
      listCardsWon.add(currentCard);
    }
    
    /* clear the claimed cards */
    stackClaimedCards.clear();
  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }
  
}
