package com.scottlinenberger.game;

import static com.scottlinenberger.error.ErrorReporter.reportError;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.scottlinenberger.cards.AcesSetting;
import com.scottlinenberger.cards.PlayingCard;
import com.scottlinenberger.constants.GameConstants;
import com.scottlinenberger.error.GameError;
import com.scottlinenberger.game.player.Player;
import com.scottlinenberger.out.WarPrinter;
import com.scottlinenberger.utils.CardUtils;
import com.scottlinenberger.utils.DeckUtils;

public class GameWar {

  private List<Player> listPlayers;
  private Stack<PlayingCard> stackPotOfCards;
  private Player player1;
  private Player player2;
  private int indexRound = 1;

  public GameWar() {
    /* init players list */
    this.listPlayers = new ArrayList<>();
    this.stackPotOfCards = new Stack<>();
  }

  public void start() {
    System.out.println("New Game Starting: War!");

    /* verify players before getting cards */
    verifyNumberOfPlayers();

    /* set players */
    player1 = listPlayers.get(0);
    player2 = listPlayers.get(1);

    printStartingMessage();
    dealCards();
    play();
  }

  private void play() {
    /* check if the game is over */
    if (player1.getStackCards().size() == 0) {
      /* player1 is out of cards, player 2 wins */
      System.out.println(player2.getName() + " wins!");
      return;
    }

    if (player2.getStackCards().size() == 0) {
      /* player2 is out of cards, player 1 wins */
      System.out.println(player1.getName() + " wins!");
      return;
    }

    WarPrinter.printRoundStart(indexRound);

    playNextCards();

    indexRound++;
    play();
  }

  private void playNextCards() {
    /* get cards from each player */
    PlayingCard cardPlayer1 = player1.getNextCard();
    PlayingCard cardPlayer2 = player2.getNextCard();
    
    /* put the cards in the pot */
    stackPotOfCards.push(cardPlayer1);
    stackPotOfCards.push(cardPlayer2);

    printCard(player1, cardPlayer1);
    printCard(player2, cardPlayer2);

    int comparisonResult = 
        CardUtils.compareCards(
            cardPlayer1, 
            cardPlayer2
        );

    switch (comparisonResult) {
      case 0:
        WarPrinter.printMessageWar();
        doWar();
        break;

      case 1:
        /* clear the war flag */
        WarPrinter.printRoundWinner(player1);
        player1.claimCards(stackPotOfCards);
        break;

      case -1:
        /* clear the war flag */
        WarPrinter.printRoundWinner(player2);
        player2.claimCards(stackPotOfCards);
        break;

      default:
        break;
    }

    System.out.println("");
  }
  

  
  private void doWar() {
    /* get cards from each player */
    PlayingCard cardPlayer1 = player1.getNextCard();
    PlayingCard cardPlayer2 = player2.getNextCard();
    
    /* put the cards in the pot */
    stackPotOfCards.push(cardPlayer1);
    stackPotOfCards.push(cardPlayer2);
    
    playNextCards();
  }

  private void printCard(Player player, PlayingCard playingCard) {
    String message = String
        .format(
            "%s: %s",
              player.getName(),
              playingCard.toString()
        );

    System.out.println(message);
  }

  private void dealCards() {
    System.out.println("Getting Deck of Cards...");

    List<PlayingCard> listCards = DeckUtils.generateDeck(AcesSetting.HIGH, 2);

    System.out.println("Shuffling Cards...");

    DeckUtils.shuffleCards(listCards);
    DeckUtils
        .dealCards(
            player1,
              player2,
              listCards);
  }

  private void verifyNumberOfPlayers() {
    /* if no players are in the game */
    if (this.listPlayers.size() == 0) {
      reportError(GameError.PLAYERS_NO_PLAYERS);
    }

    int numberOfPlayers = GameConstants.NUMBER_OF_PLAYERS_WAR;

    if (this.listPlayers.size() < numberOfPlayers) {
      reportError(GameError.PLAYERS_NOT_ENOUGH_PLAYERS);
    }
  }

  private void printStartingMessage() {

  }

  public GameWar addPlayer(Player player) {
    this.listPlayers.add(player);
    return this;
  }

}
