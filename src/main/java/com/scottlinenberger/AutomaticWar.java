package com.scottlinenberger;

import com.scottlinenberger.game.GameWar;
import com.scottlinenberger.game.player.Player;

public class AutomaticWar {

  public static void main(String[] args) {
    new GameWar()
        .addPlayer(
            new Player(
                "Scott"
            )
        )
        .addPlayer(
            new Player(
                "Vanessa"
            )
        )
        .start();
  }

}
