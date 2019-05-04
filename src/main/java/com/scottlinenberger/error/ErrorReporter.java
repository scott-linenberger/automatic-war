package com.scottlinenberger.error;

public class ErrorReporter {

  public static void reportError(GameError error) {
    System.out.println(error.getMessage());
    
    if (error.isFatal() == true) {
      System.exit(error.getCode());
    }
  }
  
}
