package com.scottlinenberger.error;

import com.scottlinenberger.constants.ErrorMessage;
import com.scottlinenberger.constants.GameConstants;
import com.scottlinenberger.constants.SystemCode;

public enum GameError {
    PLAYERS_NO_PLAYERS(
        SystemCode.NO_PLAYERS_IN_GAME,
        ErrorMessage.PLAYERS_NO_PLAYERS_IN_GAME,
        true
    ),
    PLAYERS_NOT_ENOUGH_PLAYERS(
        SystemCode.NOT_ENOUGH_PLAYERS,
        String
            .format(
                ErrorMessage.PLAYERS_NOT_ENOUGH_PLAYERS,
                  GameConstants.NUMBER_OF_PLAYERS_WAR
            ),
        true
    );

  private int code;
  private String message;
  private boolean isFatal;

  GameError(int code, String message, boolean isFatal) {
    this.code = code;
    this.message = message;
    this.isFatal = isFatal;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public boolean isFatal() {
    return isFatal;
  }
}
