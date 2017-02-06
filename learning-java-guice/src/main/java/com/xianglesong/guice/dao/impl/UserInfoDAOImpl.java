package com.xianglesong.guice.dao.impl;

import com.xianglesong.guice.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

  public int update(int uid, String name) {
    System.out.println("update name " + name + " is success!");
    return 1;
  }

}
