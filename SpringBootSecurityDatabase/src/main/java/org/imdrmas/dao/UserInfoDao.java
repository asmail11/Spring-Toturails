package org.imdrmas.dao;

import org.imdrmas.entities.UserInfo;

public interface UserInfoDao {
  public abstract UserInfo getActiveUser(String userName);
}
