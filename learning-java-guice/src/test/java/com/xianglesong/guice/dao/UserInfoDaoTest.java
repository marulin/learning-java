package com.xianglesong.guice.dao;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xianglesong.guice.module.BindDAOModule;

public class UserInfoDaoTest {
  @Test
  public void testUserInfo() {
    //
    Injector injector = Guice.createInjector(new BindDAOModule());
    UserInfoDAO userInfo = injector.getInstance(UserInfoDAO.class);
    userInfo.update(1, "world");
    UserInfoDAO userInfo2 = injector.getInstance(UserInfoDAO.class);
    Assert.assertEquals(userInfo.hashCode(), userInfo2.hashCode());
  }
}
