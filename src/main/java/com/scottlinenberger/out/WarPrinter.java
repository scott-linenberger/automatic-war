package com.scottlinenberger.out;

import com.scottlinenberger.game.player.Player;

public abstract class WarPrinter {

  private static int lineWidth = 80;

  private static String charWideBreak = "=";
  private static String charThinBreak = "-";

  public static void printRoundStart(int roundNumber) {
    System.out.println("\nRound " + roundNumber + ": ");

    printLineBreak(
        charWideBreak,
          lineWidth
    );
  }

  public static void printLineBreak(String character, int widthLine) {
    for (int i = 0; i < widthLine; i++) {
      System.out.print(character);

      if (i == widthLine - 1) {
        System.out.println(character);
      }
    }
  }

  public static void printRoundWinner(Player player) {
    System.out.println("\nRound Winner: + " + player.getName() + " +");
  }

  public static void printMessageWar() {
    System.out.println("\n >>>>> WAR <<<<<\n");
  }

}
