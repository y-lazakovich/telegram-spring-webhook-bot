package io.starter.telegram.constants;

import io.starter.telegram.cash.state.CallbackState;

public enum League {

  STANDARD(1L, CallbackState.SETTING_STANDARD),
  LEAGUE(9L, CallbackState.SETTING_LEAGUE),
  HARDCORE(2L, CallbackState.SETTING_HARDCORE),
  LEAGUE_HARDCORE(10L, CallbackState.SETTING_LEAGUE_HARDCORE);

  public final long id;
  public final CallbackState state;

  League(Long id, CallbackState state) {
    this.id = id;
    this.state = state;
  }

  public static League byCallbackState(CallbackState state) {
    for (League league : League.values()) {
      if (league.state.equals(state)) {
        return league;
      }
    }
    return null;
  }
}
