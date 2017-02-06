package com.xianglesong.guice;

import junit.framework.Assert;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xianglesong.guice.dao.UserInfoDAO;
import com.xianglesong.guice.module.BindDAOModule;

public class GuiceBootStart {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new BindDAOModule());
    UserInfoDAO userInfo = injector.getInstance(UserInfoDAO.class);
    UserInfoDAO userInfo2 = injector.getInstance(UserInfoDAO.class);
    Assert.assertEquals(userInfo.hashCode(), userInfo2.hashCode());
  }

}
