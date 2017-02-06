package com.xianglesong.guice.bind.provides;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Configure {

  String jdbcUrl;
  int loginTimeout;

  @Inject
  public Configure(@Named("JDBC URL") String jdbcUrl, int loginTimeout) {
    this.jdbcUrl = jdbcUrl;
    this.loginTimeout = loginTimeout;
  }

  @Override
  public String toString() {
    return "jdbcUrl==>" + this.jdbcUrl + "\tloginTimeout==>" + this.loginTimeout + " seconds";
  }
}
