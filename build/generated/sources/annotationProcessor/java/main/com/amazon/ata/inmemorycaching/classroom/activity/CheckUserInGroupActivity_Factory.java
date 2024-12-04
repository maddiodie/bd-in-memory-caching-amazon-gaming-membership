package com.amazon.ata.inmemorycaching.classroom.activity;

import com.amazon.ata.inmemorycaching.classroom.dao.GroupMembershipCachingDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CheckUserInGroupActivity_Factory implements Factory<CheckUserInGroupActivity> {
  private final Provider<GroupMembershipCachingDao> groupMembershipCachingDaoProvider;

  public CheckUserInGroupActivity_Factory(
      Provider<GroupMembershipCachingDao> groupMembershipCachingDaoProvider) {
    this.groupMembershipCachingDaoProvider = groupMembershipCachingDaoProvider;
  }

  @Override
  public CheckUserInGroupActivity get() {
    return new CheckUserInGroupActivity(groupMembershipCachingDaoProvider.get());
  }

  public static CheckUserInGroupActivity_Factory create(
      Provider<GroupMembershipCachingDao> groupMembershipCachingDaoProvider) {
    return new CheckUserInGroupActivity_Factory(groupMembershipCachingDaoProvider);
  }
}
